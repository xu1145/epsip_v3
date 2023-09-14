<template>

  <div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">统计盘点</el-breadcrumb-item>
        <el-breadcrumb-item>库存盘点</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div>
      <el-form ref="CustomerForm" style="margin-left: 200px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="需要盘点的商品ID:" label-width="150px">
              <el-input size="mini" prefix-icon="el-icon-edit" placeholder="请输入商品ID" v-model="productCheck.productId"></el-input>
            </el-form-item>
            <el-form-item label="需要盘点的仓库ID:" label-width="150px">
              <el-input size="mini" prefix-icon="el-icon-edit" placeholder="请输入仓库ID" v-model="productCheck.warehouseId"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

      </el-form>
      <div></div>
      <span slot="footer" class="dialog-footer" style="margin-left: 350px">
        <el-button size="small" type="primary" @click="checkProduct">盘点</el-button>
    </span>
    </div>



    <!-- 表格信息部分 -->
    <div style="margin-top: 50px">
      <el-table :data="productInfos" style="width: 100%">
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column prop="productId" label="货品ID"> </el-table-column>
        <el-table-column prop="name" label="货品名">
        </el-table-column>
        <el-table-column prop="introduction" label="商品描述">
        </el-table-column>
      </el-table>
    </div>

    <div style="margin-top: 20px">
      <b>库存：{{this.productInfoVO.number}}</b>
    </div>

    <div style="margin-top: 20px">
      <el-form ref="CustomerForm" style="margin-left: 200px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="盘点后数量:" label-width="150px">
              <el-input size="mini" prefix-icon="el-icon-edit" placeholder="请输入盘点后数量" v-model="checkUpdate.number"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

      </el-form>
      <div></div>
      <span slot="footer" class="dialog-footer" style="margin-left: 350px">
        <el-button size="small" type="primary" @click="checkUpdateProduct">修改</el-button>
    </span>
    </div>



  </div>


</template>

<script>
export default {
  name: "WarehouseList",
  data() {
    return {
      productInfos: [],
      productCheck: {
        productId: null,
        warehouseId: null,
      },
      productInfoVO: {
        productId: null,
        name: '',
        introduction: '',
        number: null,
      },

      checkUpdate: {
        productId: null,
        warehouseId: null,
        number: null,
      }

    }
  },

  methods: {
    checkProduct() {
      this.postRequest("/product/check", this.productCheck).then((resp) => {
        if (resp) {
          this.productInfos = resp.object;
          //
          this.productInfoVO.productId = this.productInfos[0].productId;
          this.productInfoVO.name = this.productInfos[0].name;
          this.productInfoVO.introduction = this.productInfos[0].introduction;
          this.productInfoVO.number = this.productInfos[0].number;
          this.checkUpdate.productId = this.productInfos[0].productId;
          this.checkUpdate.warehouseId = this.productInfos[0].warehouseId;
          this.checkUpdate.number = this.productInfos[0].number;

        }
      });
    },

    checkUpdateProduct() {
      this.putRequest("/product/check/update", this.checkUpdate).then((resp) => {
        if (resp) {
          this.checkProduct();
        }
      });

    },




  }

}
</script>

<style scoped>

</style>
