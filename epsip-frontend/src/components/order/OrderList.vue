<template>


  <div>
      <div>
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">订单处理</el-breadcrumb-item>
          <el-breadcrumb-item>订单显示</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    <div>
      <span>
        <el-input v-model="orderId" placeholder="输入订单号搜索" style="width: 200px"></el-input>
      </span>
      <span>
        <el-button type="primary" @click="orderListById">搜索</el-button>
      </span>

    </div>


    <!-- 表格信息部分 -->
    <div style="margin-top: 10px">
      <el-table :data="orders" style="width: 100%">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="id" label="订单编号"></el-table-column>
        <el-table-column prop="createTime" label="开单时间">
        </el-table-column>
        <el-table-column prop="customerId" label="客户ID">
        </el-table-column>
        <el-table-column prop="status" label="订单状态">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.status === 1"
                    type="warning"
                    disable-transitions>待出库
            </el-tag>
            <el-tag v-if="scope.row.status === 2"
                    type="primary"
                    disable-transitions>已完成
            </el-tag>
            <el-tag v-if="scope.row.status === 3"
                    type="info"
                    disable-transitions>已退货
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini">查看详情</el-button>
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
      orderId: null,
    }
  },

  mounted() {
    this.initorders();
  },

  methods: {
    initorders() {
      this.getRequest("/order/list").then((resp) => {
        if (resp) {
          this.orders = resp;
        }
      });
    },
    orderListById() {
      this.getRequest("/order/list/" + (this.orderId == null || this.orderId == '' ? -1 : this.orderId)).then((resp) => {
        if (resp) {
          this.orders = resp.object;
        }
      });
    },


  }

}
</script>

<style scoped>

</style>
