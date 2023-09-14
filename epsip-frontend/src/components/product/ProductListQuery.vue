<template>


<div>
    <div>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">信息查询</el-breadcrumb-item>
        <el-breadcrumb-item>分仓查询</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
  <div>
    <el-form ref="CustomerForm" style="margin-left: 300px">
      <el-row>
        <el-col :span="8">
          <el-form-item label="请输入仓库ID:" label-width="120px">
            <el-input size="mini" prefix-icon="el-icon-edit" placeholder="请输入仓库ID" v-model="warehouseId"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>
    <div></div>
    <span slot="footer" class="dialog-footer" style="margin-left: 400px">
        <el-button size="small" type="primary" @click="queryProductList">搜索</el-button>
    </span>
  </div>



  <!-- 表格信息部分 -->
  <div style="margin-top: 100px">
    <el-table :data="productInfos" style="width: 100%">
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="id" label="货品ID"> </el-table-column>
      <el-table-column prop="name" label="货品名称">
      </el-table-column>
      <el-table-column prop="number" label="库存">
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
      warehouseId: null,
      productInfos: [],
    }
  },

  methods: {
    queryProductList() {
      this.getRequest("/product/list/" + this.warehouseId).then((resp) => {
        if (resp) {
          this.productInfos = resp.object;
        }
      });
    },




  }

}
</script>

<style scoped>

</style>
