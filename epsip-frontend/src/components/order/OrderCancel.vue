<template>
  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">订单处理</el-breadcrumb-item>
        <el-breadcrumb-item>订单退货</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div style="margin-left: 100px;margin-top: 20px;">

      <div>
        <b>退货订单号</b>
      </div>
      <div style="margin-top: 20px;">
        <el-input v-model="orderCancel.id" placeholder="输入订单号搜索" style="width: 400px"></el-input>
      </div>
      <div style="margin-top: 20px;">
        <el-button size="small" type="primary" @click="cancelOrder">整单退货</el-button>
      </div>
    </div>
  </div>


</template>

<script>
export default {
  name: "CustomerAdd",
  data() {
    return {
      orderCancel: {
        id: null,
      }
    }
  },

  methods: {
    cancelOrder() {
      this.$confirm(
        "此操作将整单退货, 是否继续?",
        "提示",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(() => {
          this.putRequest("/order/cancel", this.orderCancel).then((resp) => {
            if (resp) {
              this.orderCancel.id = null;
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消退货",
          });
        });
    },


  }


}
</script>

<style scoped>

</style>
