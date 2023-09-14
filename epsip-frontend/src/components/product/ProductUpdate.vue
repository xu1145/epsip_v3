<template>


  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">信息录入</el-breadcrumb-item>
        <el-breadcrumb-item>修改定价</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
  <div>
    <el-form ref="CustomerForm">
      <el-row>
        <el-col :span="8">
          <el-form-item label="商品名称:" label-width="100px">
            <el-select size="mini" v-model="product.id" placeholder="请选择">
              <el-option v-for="item in productList" :key="item.id" :label="item.name" :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="商品零售价:" label-width="100px">
            <el-input size="mini" prefix-icon="el-icon-edit"
                      placeholder="请输入商品零售价" v-model="product.retail"></el-input>
          </el-form-item>
          <el-form-item label="商品批发价:" label-width="100px">
            <el-input size="mini" prefix-icon="el-icon-edit"
                      placeholder="请输入商品批发价" v-model="product.wholeSaleprice"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>
    <div></div>
    <span slot="footer" class="dialog-footer" style="margin-left: 100px">
        <el-button size="small" type="primary" @click="updateProduct">设定价格</el-button>
    </span>
  </div>
  </div>


</template>

<script>
export default {
  name: "ProductUpdate",
  data () {
    return {
      product:{
        id: null,
        retail: null,
        wholeSaleprice: null,
      },
      productList:[],
    }
  },

  mounted() {
    this.initProductList();
  },

  methods: {

    initProductList() {
      this.getRequest("/product/list").then((resp) => {
        if (resp) {
          this.productList = resp;
        }
      });
    },

    updateProduct() {
      this.putRequest("/product/update", this.product).then((resp) => {
        if (resp) {
          this.product = {
            id: null,
            retail: null,
            wholeSaleprice: null,
          }
        }
      });
    },


  }

}
</script>

<style scoped>

</style>
