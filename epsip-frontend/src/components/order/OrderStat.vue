<template>


  <div>
      <div>
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">统计盘点</el-breadcrumb-item>
          <el-breadcrumb-item>销售统计</el-breadcrumb-item>
        </el-breadcrumb>
      </div>

    <table>
      <tr>
        <th width="50%">
          <div>
      <span>
        <div>
        <span style="text-align: center"><h1>客户销售状况统计</h1></span>
        <span>
        <b>请输入待统计用户的ID：</b><el-input v-model="customerQueryDTO.id" placeholder="请输入待统计用户的ID"
                                              style="width: 200px"></el-input>
      </span>
        <span>
        <el-button type="primary" @click="statCustomer">统计</el-button>
      </span>
      </div>

        <!-- 表格信息部分 -->
      <div style="margin-top: 10px">
        <el-table :data="customerQueryVO" style="width: 100%">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column prop="id" label="ID"></el-table-column>
          <el-table-column prop="name" label="名称">
          </el-table-column>
          <el-table-column prop="count" label="个数">
          </el-table-column>
        </el-table>
      </div>
      </span>
          </div>
        </th>

        <th width="200px;"></th>

        <th width="50%">
          <div>
      <span>
        <div>
        <span style="text-align: center"><h1>货品销售状况统计</h1></span>
        <span>
        <b>请输入待统计货品的ID：</b><el-input v-model="productQueryDTO.id" placeholder="请输入待统计货品的ID"
                                              style="width: 200px"></el-input>
      </span>
        <span>
        <el-button type="primary" @click="statProduct">统计</el-button>
      </span>
      </div>

        <!-- 表格信息部分 -->
      <div style="margin-top: 10px">
        <el-table :data="productQueryVO" style="width: 100%">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column prop="id" label="ID"></el-table-column>
          <el-table-column prop="name" label="客户姓名">
          </el-table-column>
          <el-table-column prop="count" label="个数">
          </el-table-column>
        </el-table>
      </div>
      </span>
          </div>
        </th>
      </tr>
    </table>


  </div>


</template>

<script>
export default {
  name: "EmployeeList",
  data() {
    return {
      customerQueryVO: [],
      productQueryVO: [],
      customerQueryDTO: {
        id: null,
      },
      productQueryDTO: {
        id: null,
      },
    }
  },


  methods: {

    statCustomer() {
      this.getRequest("/order/stat/cust/" + (this.customerQueryDTO.id == null || this.customerQueryDTO.id == '' ? -1 : this.customerQueryDTO.id)).then((resp) => {
        if (resp) {
          this.customerQueryVO = resp.object;
        }
      });
    },

    statProduct() {
      this.getRequest("/order/stat/prod/" + (this.productQueryDTO.id == null || this.productQueryDTO.id == '' ? -1 : this.productQueryDTO.id)).then((resp) => {
        if (resp) {
          this.productQueryVO = resp.object;
        }
      });
    },


  }

}
</script>

<style scoped>

</style>
