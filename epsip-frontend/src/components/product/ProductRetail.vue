<template>


  <div>
      <div>
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">订单处理</el-breadcrumb-item>
          <el-breadcrumb-item>零售收银</el-breadcrumb-item>
        </el-breadcrumb>
      </div>

    <table>
      <tr>
        <th width="50%">


          <div
            v-for="(item, index) in payvo.productIdList"
            :key="index"
          >
            <b>第{{ index + 1 }}个商品ID: </b>
            <el-input
              style="width: 300px;"
              placeholder="请输入商品id"
              v-model="payvo.productIdList[index]"
              show-word-limit
            >
              <el-button
              >删除
              </el-button>
            </el-input>
          </div>

          <div
            v-for="(item, index) in payvo.countList"
            :key="index"
          >
            <b>第{{ index + 1 }}个商品数量: </b>
            <el-input
              style="width: 300px;"
              placeholder="请输入商品数量"
              v-model="payvo.countList[index]"
              show-word-limit
            >
            </el-input>
          </div>
          <div>
                      <span>
            <el-button type="primary" @click="showPay">结账</el-button>
          </span>
            <span>
        <el-button type="primary" @click="showPay">确认支付</el-button>
      </span>
            <span>
        <el-button @click="addInput">新增一类商品</el-button>
      </span>
            <span>
        <el-button @click="delInput">删除一类商品</el-button>
      </span>
          </div>


        </th>

        <th width="200px;"></th>

        <th width="50%">
          <div>
      <span>
        <div>
        <span>
        <b>请输入商品名称：</b><el-input v-model="query.name" placeholder="请输入商品名称"
                                        style="width: 200px"></el-input>
      </span>
        <span>
        <el-button type="primary" @click="listByName">搜索</el-button>
      </span>
      </div>

        <!-- 表格信息部分 -->
      <div style="margin-top: 10px">
        <el-table :data="productList" style="width: 100%">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column prop="id" label="商品id"></el-table-column>
          <el-table-column prop="name" label="商品名称">
          </el-table-column>
          <el-table-column prop="introduction" label="商品描述">
          </el-table-column>
                <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="add(scope.row)" type="success" class="el-icon-circle-plus-outline" circle></el-button>
        </template>
      </el-table-column>
        </el-table>
      </div>
      </span>
          </div>
        </th>


      </tr>
    </table>

    <div>
      <h1>本单总价为：{{ this.price }}</h1>
    </div>


    <el-dialog :title="title" :visible.sync="dialogVisible" width="20%">
      <div>
        <el-select v-model="payvo.customerId" placeholder="请选择">
          <el-option v-for="item in customerList" :key="item.id" :label="item.name" :value="item.id">
          </el-option>
        </el-select>
      </div>

      <div></div>
      <span slot="footer" class="dialog-footer">
        <el-button size="small" @click="dialogVisible = false">取 消</el-button>
        <el-button size="small" type="primary" @click="pay">确认支付</el-button>
      </span>
    </el-dialog>


  </div>


</template>

<script>
export default {
  name: "EmployeeList",
  data() {
    return {

      dialogVisible: false,

      payvo: {
        productIdList: [],
        countList: [],
        customerId: null,
      },

      title: '',

      productList: [],
      customerList:[],

      query: {
        name: '',
      },

      price: null,

    }
  },

  mounted() {
    this.initProductList();
    this.initCustomerList();
  },


  methods: {

    showPay() {
      this.title = "用户支付界面";
      this.dialogVisible = true;
      this.payvo.customerId = null;
    },

    addInput() {
      this.payvo.productIdList.push('');
      this.payvo.countList.push('');
    },
    delInput() {
      this.payvo.productIdList.pop();
      this.payvo.countList.pop();
    },

    initCustomerList() {
      this.getRequest("/customer/list").then((resp) => {
        if (resp) {
          this.customerList = resp;
        }
      });
    },

    initProductList() {
      this.getRequest("/product/list").then((resp) => {
        if (resp) {
          this.productList = resp;
        }
      });
    },

    listByName() {
      this.postRequest("/product/list/name", this.query).then((resp) => {
        if (resp) {
          this.productList = resp;
        }
      });
    },

    pay() {
      this.postRequest("/order/pay", this.payvo).then((resp) => {
        if (resp) {
          this.price = resp.object.price;
          this.dialogVisible = true;
        }
      });
    },

    add(data) {
      var index = this.payvo.productIdList.indexOf(parseInt(data.id));
      if (index >= 0) {
        this.payvo.countList[index] += 1;
      } else {
          this.payvo.productIdList.push(data.id);
          this.payvo.countList.push(0);
      }
    }
  }

}
</script>

<style scoped>

</style>
