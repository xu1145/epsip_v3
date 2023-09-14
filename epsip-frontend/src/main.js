// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// 导入ElementUI依赖
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import {getRequest} from './utils/api'
import {putRequest} from './utils/api'
import {postRequest} from './utils/api'
import {deleteRequest} from './utils/api'

// 使用ElementUI
Vue.use(ElementUI)
Vue.prototype.getRequest = getRequest;//注入到vue对象
Vue.prototype.postRequest = postRequest;//注入到vue对象
Vue.prototype.putRequest = putRequest;//注入到vue对象
Vue.prototype.deleteRequest = deleteRequest;//注入到vue对象


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
