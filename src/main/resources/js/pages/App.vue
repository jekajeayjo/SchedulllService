<template>
    <v-app>

<tab-menu></tab-menu>
        <!--       -->
        <!--        <transition name="fade">-->
        <v-row>
            <v-col md="10" offset-md="1">
            <v-content >
            <v-alert :value="error" type="warning">
                {{error}}
            </v-alert>
            <router-view ></router-view>
            <FlashMessage></FlashMessage>
        </v-content>
            </v-col>
        </v-row>

        <!--        </transition>-->
    </v-app>
</template>

<script>
    import TabMenu from "../view/TransactionView.vue";
    export default {

        components: {
            TabMenu

        },
        data() {
            return {
                showLeftMenu: false,
                toggle: false,
                show: {
                    type: Boolean,
                    required: false,
                    default: false
                },
                showSearchcards: true,
                showType: 'Mainmenu'
            }
        },
        mounted() {
            this.showLeftMenu = this.isauthenticated
        },
        computed: {
            isauthenticated() {
                return this.$store.getters.isUserAuthenticated
            },
            error() {
                //getters обьявляем ка кпростые переменные
                return this.$store.getters.getError
            },
        },
        watch: {
            isauthenticated(val) {
                if (val === true)
                    this.showLeftMenu = true
                else
                    this.showLeftMenu = false
            }
        },
        methods: {
            setComponentName(name) {
                this.showType = name
            }
        }
    }
</script>

<style>
    .info_img_photo {
        content: url('../../static/images/info.png');
        width: 2em;
        height: 2em;
    }

    .tab-link a:hover {
        text-decoration: none;
    }

    .tab-link a {
        color: black !important;
    }

    .fade-enter-active, .fade-leave-active {
        transition: opacity .5s;
    }

    .fade-enter, .fade-leave-to /* .fade-leave-active до версии 2.1.8 */
    {
        opacity: 0;
    }


    .logo {
        margin-top: 1em;
        margin-left: 1em;
        margin-bottom: 1em;
    }

    .yellow {
        background: #FAD727;
    }


    .bor {
        border-right: 1px solid rgba(0, 0, 0, 0.11); /*добавляем бордюр справа*/
    }

    .lin {
        border-right: 1px solid rgba(0, 0, 0, 0.11); /*добавляем бордюр справа*/
        text-decoration: none; /*убираем подчеркивание текста ссылок*/
        background: #E4E4E4; /*добавляем фон к пункту меню*/
        color: #000000; /*меняем цвет ссылок*/
        padding: .7em 15px; /*добавляем отступ*/
        font-family: Roboto; /*меняем шрифт*/
        line-height: 50px; /*ровняем меню по вертикали*/
        display: block;

        border-right: 1px solid rgba(0, 0, 0, 0.11); /*добавляем бордюр справа*/
        -moz-transition: all 0.3s 0.01s ease; /*делаем плавный переход*/
        -o-transition: all 0.3s 0.01s ease;
        -webkit-transition: all 0.3s 0.01s ease;
    }

    .lin_active {
        background-color: #D3D3D3;
        text-decoration: none; /*убираем подчеркивание текста ссылок*/
        /*background: #E4E4E4; !*добавляем фон к пункту меню*!*/
        color: #000000; /*меняем цвет ссылок*/
        padding: .7em 15px; /*добавляем отступ*/
        font-family: Roboto; /*меняем шрифт*/
        line-height: 50px; /*ровняем меню по вертикали*/
        display: block;

        border-right: 1px solid rgba(0, 0, 0, 0.11); /*добавляем бордюр справа*/
        -moz-transition: all 0.3s 0.01s ease; /*делаем плавный переход*/
        -o-transition: all 0.3s 0.01s ease;
        -webkit-transition: all 0.3s 0.01s ease;
    }

    .lin:hover {
        background: #D3D3D3; /*добавляем эффект при наведении*/

    }

    .lin::after {
        background: #D3D3D3;
    }

    li {
        float: left; /*Размещаем список горизонтально для реализации меню*/
        position: relative; /*задаем позицию для позиционирования*/
    }

    /*Стили для скрытого выпадающего меню*/
    li > ul {
        position: absolute;
        top: 25px;
        display: none;
    }

    /*Делаем скрытую часть видимой*/
    li:hover > ul {
        display: block;
        width: 250px; /*Задаем ширину выпадающего меню*/
        z-index: 9999;
    }

    li:hover > ul > li {
        float: none; /*Убираем горизонтальное позиционирование*/
    }

    .header-menu {
        background-color: #E4E4E4;

    }

    .log-out {
        color: black;
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 18px;
    }
</style>