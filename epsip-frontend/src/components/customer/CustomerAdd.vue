<template>

  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">信息录入</el-breadcrumb-item>
        <el-breadcrumb-item>添加客户</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div >
      <el-form ref="CustomerForm" style="margin: 0 auto; text-align: center">
        <el-row>
          <el-col :span="8">
            <el-form-item label="顾客姓名:" prop="name" label-width="100px">
              <el-input size="mini" prefix-icon="el-icon-edit" placeholder="请输入顾客姓名"
                        v-model="customer.name"></el-input>
            </el-form-item>
            <el-form-item label="顾客电话:" prop="idcard" label-width="100px">
              <el-input size="mini" prefix-icon="el-icon-edit"
                        placeholder="请输入顾客电话" v-model="customer.phone"></el-input>
            </el-form-item>
            <el-form-item label="送货地址:" prop="idcard" label-width="100px">
              <el-input size="mini" prefix-icon="el-icon-edit"
                        placeholder="请输入送货地址" v-model="customer.address"></el-input>
            </el-form-item>

          </el-col>
        </el-row>

      </el-form>
      <div></div>
      <span slot="footer" class="dialog-footer" style="margin-left: 100px">
        <el-button size="small" type="primary" @click="addCustomer">添加顾客</el-button>
      </span>
    </div>
  </div>



</template>

<script>
export default {
  name: "CustomerAdd",
  data() {
    return {
      customer: {
        id: null,
        name: '',
        phone: '',
        address: '',
      }
    }
  },

  methods: {
    addCustomer() {
      this.postRequest("/customer/add", this.customer).then((resp) => {
        if (resp) {
          this.customer = {
            id: null,
            name: '',
            phone: '',
            address: '',
          }
        }
      });
    },


  }


}
</script>

<style scoped>

</style>
