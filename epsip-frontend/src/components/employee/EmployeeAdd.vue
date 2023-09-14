<template>

  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">信息查询</el-breadcrumb-item>
        <el-breadcrumb-item>添加员工</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div>
      <el-form ref="CustomerForm" style="margin-left: 100px;margin-top: 50px;">
        <el-row>
          <el-col :span="8">
            <el-form-item label="员工姓名:" label-width="100px">
              <el-input size="mini" prefix-icon="el-icon-edit" placeholder="请输入员工姓名" v-model="employee.name"></el-input>
            </el-form-item>
            <el-form-item label="员工性别:" label-width="100px">
              <el-radio-group v-model="employee.gender">
                <el-radio label="男">男</el-radio>
                <el-radio label="女">女</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item label="员工年龄:" label-width="100px">
              <el-input size="mini" prefix-icon="el-icon-edit"
                        placeholder="请输入员工年龄" v-model="employee.age"></el-input>
            </el-form-item>
            <el-form-item label="员工电话:" label-width="100px">
              <el-input size="mini" prefix-icon="el-icon-edit"
                        placeholder="请输入员工电话" v-model="employee.phone"></el-input>
            </el-form-item>
            <el-form-item label="员工职位:" label-width="100px">
              <el-input size="mini" prefix-icon="el-icon-edit"
                        placeholder="请输入员工职位" v-model="employee.position"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

      </el-form>
      <div></div>
      <span slot="footer" class="dialog-footer" style="margin-left: 200px">
        <el-button size="small" type="primary" @click="addEmployee">添加员工</el-button>
    </span>
      <div>
        <b>员工初始账号：0</b>
        <br>
        <br>
        <b>员工初始密码：111111</b>
      </div>
    </div>
  </div>


</template>

<script>
export default {
  name: "EmployeeAdd",
  data () {
    return {
      employee:{
        id: null,
        name: '',
        gender: '',
        age: '',
        phone: '',
        position: '',
      }
    }
  },

  methods: {
    addEmployee() {
      this.postRequest("/employee/add", this.employee).then((resp) => {
        if (resp) {
          this.employee = {
            id: null,
            name: '',
            gender: '',
            age: null,
            phone: '',
            position: '',
          }
        }
      });
    },


  }

}
</script>

<style scoped>

</style>
