<template>

  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">信息查询</el-breadcrumb-item>
        <el-breadcrumb-item>查看仓库</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

  <!-- 表格信息部分 -->
  <div style="margin-top: 10px">
    <el-table :data="warehouses" style="width: 100%">
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="id" label="仓库ID"> </el-table-column>
      <el-table-column prop="type" label="仓库类型">
      </el-table-column>
      <el-table-column prop="address" label="地址">
      </el-table-column>
      <el-table-column prop="phone" label="电话">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="danger" @click="delWarehouse(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
  </div>

</template>

<script>
export default {
  name: "WarehouseList",
  data() {
    return {
      warehouses: []
    }
  },

  mounted() {
    this.initWarehouses();
  },

  methods: {
    initWarehouses() {
      this.getRequest("/warehouse/list").then((resp) => {
        if (resp) {
          this.warehouses = resp;
        }
      });
    },

    delWarehouse(data) {
      this.$confirm(
        "此操作将永久删除[" + data.id + "]的仓库信息, 是否继续?",
        "提示",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(() => {
          this.deleteRequest("/warehouse/del/" + data.id).then((resp) => {
            if (resp) {
              this.initWarehouses();
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
