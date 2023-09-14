<template>

  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">信息查询</el-breadcrumb-item>
        <el-breadcrumb-item>所有员工</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
  <!-- 表格信息部分 -->
  <div style="margin-top: 10px">
    <el-table :data="employees" style="width: 100%">
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="id" label="员工ID"> </el-table-column>
      <el-table-column prop="position" label="员工职位">
      </el-table-column>
      <el-table-column prop="name" label="员工姓名">
      </el-table-column>
      <el-table-column prop="phone" label="电话">
      </el-table-column>
      <el-table-column prop="age" label="年龄">
      </el-table-column>
      <el-table-column prop="gender" label="性别">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="danger" @click="delEmployee(scope.row)">删除</el-button>
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
      employees: []
    }
  },

  mounted() {
    this.initEmployees();
  },

  methods: {
    initEmployees() {
      this.getRequest("/employee/list").then((resp) => {
        if (resp) {
          this.employees = resp;
        }
      });
    },

    delEmployee(data) {
      this.$confirm(
        "此操作将永久删除[" + data.name + "]的员工信息, 是否继续?",
        "提示",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(() => {
          this.deleteRequest("/employee/del/" + data.id).then((resp) => {
            if (resp) {
              this.initEmployees();
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
