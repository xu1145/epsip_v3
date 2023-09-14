<template>

  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">信息录入</el-breadcrumb-item>
        <el-breadcrumb-item>添加货品</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
  <div>
    <el-form ref="CustomerForm">
      <el-row>
        <el-col :span="8">
          <el-form-item label="商品名:" label-width="100px">
            <el-input size="mini" prefix-icon="el-icon-edit" placeholder="请输入商品名" v-model="product.name"></el-input>
          </el-form-item>

          <el-form-item label="商品进价:" label-width="100px">
            <el-input size="mini" prefix-icon="el-icon-edit"
                      placeholder="请输入商品进价" v-model="product.purchasEprice"></el-input>
          </el-form-item>
          <el-form-item label="商品简介:" label-width="100px">
            <el-input type="textarea" size="mini" prefix-icon="el-icon-edit"
                      placeholder="请输入商品简介" v-model="product.introduction"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>
    <div></div>
    <span slot="footer" class="dialog-footer" style="margin-left: 100px">
        <el-button size="small" type="primary" @click="addProduct">添加商品</el-button>
    </span>
  </div>
  </div>


</template>

<script>
export default {
  name: "ProductAdd",
  data () {
    return {
      product:{
        id: null,
        name: '',
        purchasEprice: '',
        introduction: '',
      }
    }
  },

  methods: {
    addProduct() {
      this.postRequest("/product/add", this.product).then((resp) => {
        if (resp) {
          this.product = {
            id: null,
            name: '',
            purchasEprice: '',
            introduction: '',
          }
        }
      });
    },


  }

}
</script>

<style scoped>

</style>
