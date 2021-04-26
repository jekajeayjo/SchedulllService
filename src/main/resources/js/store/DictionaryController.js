export  default {
    state:{
        menuList:[],
        roleList:[]
    },
    mutations:{
        SET_MENU_LIST(state,payload)
        {
            state.menuList=payload
        },
        SET_ROLE_LIST(state,payload)
        {
            state.roleList=payload
        }
    },
    actions:{
        GET_MENU_LIST({commit, dispatch}, payload) {
            console.log('GET_MENU_LIST')
            dispatch('SEND_REQUEST_GET', payload)
                .then(resolve => {
                        console.log('GET_MENU_LIST', resolve)
                        commit('SET_MENU_LIST', resolve)


                    }
                )
        },
        GET_ROLE_LIST({commit, dispatch}, payload) {
            console.log('SET_ROLE_LIST')
            dispatch('SEND_REQUEST_GET', payload)
                .then(resolve => {
                        console.log('SET_ROLE_LIST', resolve)
                        commit('SET_ROLE_LIST', resolve)


                    }
                )
        },
    },
    getters:{
        getMenuList:(state)=>state.menuList,
        getRoleList:(state)=>state.roleList
    }
}