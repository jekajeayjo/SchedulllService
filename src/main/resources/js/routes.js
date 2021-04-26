import Store from './store'
import Vue from 'vue'
import VueRouter from 'vue-router'



import ScheduleForm from "./view/ScheduleForm.vue";
import TransactionView from "./view/TransactionView.vue";

Vue.use(VueRouter)
let router = new VueRouter({
    routes: [
        {path:'/',component: ScheduleForm},
        {path:'/view_transaction',component: TransactionView},

    ]
})



// // первый способ проерки guard
// function AuthGuard(from,to,next) {
// if (Store.getters.isUserAuthenticated)
//     next()
//     else
//         next('login')
// }
export default router