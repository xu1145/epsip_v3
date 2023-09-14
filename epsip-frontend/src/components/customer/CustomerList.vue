<template>

  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">信息查询</el-breadcrumb-item>
        <el-breadcrumb-item>所有客户</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 表格信息部分 -->
    <div style="margin-top: 10px">
      <el-table :data="customers" style="width: 100%">
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column prop="id" label="客户ID"> </el-table-column>
        <el-table-column prop="name" label="客户姓名">
        </el-table-column>
        <el-table-column prop="phone" label="客户电话">
        </el-table-column>
        <el-table-column prop="address" label="送货地址">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" type="danger" @click="delCustomer(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>

</template>

<script>
export default {
  name: "CustomerList",

  data() {
    return {
      customers: []
    }
  },

  mounted() {
    this.initCustomers();
  },

  methods: {
    initCustomers() {
      this.getRequest("/customer/list").then((resp) => {
        if (resp) {
          this.customers = resp;
        }
      });
    },

    delCustomer(data) {
      this.$confirm(
        "此操作将永久删除[" + data.name + "]的客户信息, 是否继续?",
        "提示",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(() => {
          this.deleteRequest("/customer/del/" + data.id).then((resp) => {
            if (resp) {
              this.initCustomers();
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },


  }

}
</script>

<style scoped>

</style>
