<template>


  <div>
      <div>
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">订单处理</el-breadcrumb-item>
          <el-breadcrumb-item>订单配货</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    <!-- 表格信息部分 -->
    <div style="margin-top: 10px">
      <el-table :data="orders" style="width: 100%">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="id" label="订单编号"></el-table-column>
        <el-table-column prop="createTime" label="开单时间">
        </el-table-column>
        <el-table-column prop="status" label="订单状态">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.status === 1"
                    type="danger"
                    disable-transitions>未出库
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini">查看详情</el-button>
          </template>
        </el-table-column>
        <el-table-column label="出库">
          <template slot-scope="scope">
            <el-button size="mini" type="success" @click="allowOrder(scope.row)">配货完成</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>


  </div>


</template>

<script>
export default {
  name: "EmployeeList",
  data() {
    return {
      orders: [],
    }
  },

  mounted() {
    this.initorders();
  },

  methods: {
    initorders() {
      this.getRequest("/order/list/no/allow").then((resp) => {
        if (resp) {
          this.orders = resp;
        }
      });
    },

    allowOrder(data) {
      this.putRequest("/order/allow", data).then((resp) => {
        if (resp) {
          this.initorders();
        }
      });
    },


  }

}
</script>

<style scoped>

</style>
