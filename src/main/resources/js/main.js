import Vue from 'vue'
import App from './pages/App.vue'
import VueRouter from 'vue-router'
import router from './routes';
import Vuelidate from 'vuelidate'
import VModal from 'vue-js-modal'
import Notifications from 'vue-notification'
import Vuetify from "vuetify";
import 'vuetify/dist/vuetify.min.css'
import 'vuetify/dist/vuetify.min'
import {BootstrapVue, IconsPlugin} from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import store from './store'
import vuetify from './plugins/vuetify'
import axios from 'axios'
import VueAxios from 'vue-axios'
import VueSwal from 'vue-swal'

import FlashMessage from '@smartweb/vue-flash-message';


Vue.config.productionTip = false;
// Vue.use(VueAxios, axios)
// Install BootstrapVue
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)
Vue.use(Vuelidate);
Vue.use(VueAxios, axios)
Vue.use(VModal);
Vue.use(VueRouter);
Vue.use(Notifications);
Vue.use(Vuetify)
Vue.use(FlashMessage);
Vue.use(VueSwal)



new Vue({
    store,
    vuetify,
    el: '#app',
    created() {
        // let vm=this
        //   this.$store.dispatch('STATE_CHANGED', vm.$store.getters.isUserAuthenticated)
        // console.log(vm.$store.getters.isUserAuthenticated)
    },
    render: a => a(App),
    router
});
// new Vue({
//     router,
//
//
//     render: h => h(App),
//     created() {
//         // let vm=this
//         //   this.$store.dispatch('STATE_CHANGED', vm.$store.getters.isUserAuthenticated)
//         // console.log(vm.$store.getters.isUserAuthenticated)
//     }
// }).$mount('#app')