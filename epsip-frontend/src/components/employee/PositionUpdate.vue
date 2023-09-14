<template>


  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">信息录入</el-breadcrumb-item>
        <el-breadcrumb-item>设定职位</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div>
      <el-form ref="CustomerForm" >
        <el-row>
          <el-col :span="8">
            <el-form-item label="员工id:" label-width="100px">
              <el-input size="mini" prefix-icon="el-icon-edit" placeholder="请输入员工id" v-model="employeevo.id"></el-input>
            </el-form-item>

            <el-form-item label="员工职位:" label-width="100px">
              <el-input size="mini" prefix-icon="el-icon-edit"
                        placeholder="请输入员工职位" v-model="employeevo.position"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

      </el-form>
      <div></div>
      <span slot="footer" class="dialog-footer" style="margin-left: 250px">
        <el-button size="small" type="primary" @click="updatePosition">设定权限</el-button>
    </span>
    </div>

  </div>


</template>

<script>
export default {
  name: "PositionUpdate",
  data () {
    return {
      employeevo:{
        id: null,
        position: '',
      }
    }
  },

  methods: {
    updatePosition() {
      this.putRequest("/employee/update/position", this.employeevo).then((resp) => {
        if (resp) {
          this.employeevo = {
            id: null,
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
