<template>
   <div>
       <v-tabs
               v-model="tab"
               fixed-tabs
               align-with-title
               background-color="indigo"
               dark
       >

           <v-tab

                   v-for="item in items"
                   :key="item.name"
           >
               {{ item.name }}
           </v-tab>
       </v-tabs>
       <component :is="pageComp"></component>
   </div>
</template>

<script>
    import ListTransactions from "./transaction/ListTransactions.vue";
    export default {
        name: "TransactionView",
        components:{
            ListTransactions
        },
        data()
        {
            return{
                pageComp:'ListTransactions',
                tab: null,
                items: [
                    {      name:'Список транзакций',route:'/list_transaction'}
                ],
            }
        },
        methods:{
            switchComponent(comp)
            {
                this.pageComp=comp

            },
        }
    }
</script>

<style scoped>

</style>