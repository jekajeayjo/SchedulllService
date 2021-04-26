<template >
    <v-card class="ml-5 mr-2">

        <!--        КНОПКА ДЛЯ ПОИСКА-->
        <v-card-title>
            <v-text-field
                    dense
                    v-model="search"
                    append-icon="search"
                    label="Поиск"
                    single-line
                    hide-details
            ></v-text-field>
        </v-card-title>


        <!--        тАБЛИЦА-->
        <v-data-table
                dense
                no-data-text=""
                :headers="headers"
                :items="transactionsList"
                sort-by="calories"
                :search="search"
                class="elevation-1"
                :footer-props="{
        showFirstLastPage: true,
        firstIcon: 'mdi-arrow-collapse-left',
        lastIcon: 'mdi-arrow-collapse-right',
        prevIcon: 'mdi-minus',
        nextIcon: 'mdi-plus',
          itemsPerPageText: 'Количество строк'
      }"
        >




        </v-data-table>


    </v-card>
</template>

<script>

    export default {
        name: 'ListTransactions',
        data: () => ({
            on:'',
            search:'',
            dialog: false,
            headers: [
                { text: 'Идентификатор',align: 'start',sortable: false, value: 'id', },
                { text: 'Статус транзакции', value: 'payload' },
                { text: 'Дата', value: 'ts' },
                { text: '', value: 'ty' },

            ],

           transactionsList:[],
            editedItem: {
                name: '',
                calories: 0,
                fat: 0,
                carbs: 0,
                protein: 0,
            }
        }),

        computed: {
            formTitle () {
                return this.editedIndex === -1 ? 'Новая запись' : 'Изменить запись'
            },
        },

        watch: {
            dialog (val) {
                val || this.close()
            },
        },

        created () {
            this.getTransactionsList()
        },

        methods: {
            getTransactionsList() {
                this.$store.dispatch('GET_ROWS', {
                    data:'',
                    url: '/api/get_all',
                    showRows:this.showTransactionsList
                })
            },
            showTransactionsList(rows) {
                console.log('rows,',rows)
                this.transactionsList = rows
            },

            editItem (item) {
                this.editedIndex = this.transactionsList.indexOf(item)
                this.editedItem = Object.assign({}, item)
                this.dialog = true
            },

            deleteItem (item) {
                const index = this.desserts.indexOf(item)
                confirm('Вы действительно хотите удалить запись?') && this.desserts.splice(index, 1)
            },

            close () {
                this.dialog = false
                setTimeout(() => {
                    this.editedItem = Object.assign({}, this.defaultItem)
                    this.editedIndex = -1
                }, 300)
            },

            save () {
                if (this.editedIndex > -1) {
                    Object.assign(this.desserts[this.editedIndex], this.editedItem)
                } else {
                    this.desserts.push(this.editedItem)
                }
                this.close()
            },
        },

    }
</script>

<style scoped>

</style>