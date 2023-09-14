<template>


  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">货品管理</el-breadcrumb-item>
        <el-breadcrumb-item>进货</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
  <div>
    <el-form ref="CustomerForm">
      <el-row>
        <el-col :span="8">
          <el-form-item label="商品id:" label-width="100px">
            <el-input size="mini" prefix-icon="el-icon-edit" placeholder="请输入商品id" v-model="productInfo.productId"></el-input>
          </el-form-item>

          <el-form-item label="进货数量:" label-width="100px">
            <el-input size="mini" prefix-icon="el-icon-edit"
                      placeholder="请输入进货数量" v-model="productInfo.number"></el-input>
          </el-form-item>
          <el-form-item label="仓库id:" label-width="100px">
            <el-input size="mini" prefix-icon="el-icon-edit"
                      placeholder="请输入仓库id" v-model="productInfo.warehouseId"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>
    <div></div>
    <span slot="footer" class="dialog-footer" style="margin-left: 100px">
        <el-button size="small" type="primary" @click="addProductInfo">进货</el-button>
    </span>
  </div>
  </div>


</template>

<script>
export default {
  name: "ProductAdd",
  data () {
    return {
      productInfo:{
        id: null,
        productId: null,
        number: null,
        warehouseId: null,
      }
    }
  },

  methods: {
    addProductInfo() {
      this.postRequest("/product/add/warehouse", this.productInfo).then((resp) => {
        if (resp) {
          this.productInfo = {
            id: null,
            productId: null,
            number: null,
            warehouseId: null,
          }
        }
      });
    },


  }

}
</script>

<style scoped>

</style>
