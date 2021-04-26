export default {
    state: {

        user: null,
        isAuthenticated: false,
        unsubscribeAuth: null
    },
    mutations: {

        SET_USER(state, payload) {
            console.log('payload')
            if (payload != null && payload != '') {
                state.isAuthenticated = true
                state.user = payload
            }

            // localStorage.setItem("uid",JSON.stringify(state.user.uid))
            // localStorage.setItem("isAuthenticated",JSON.stringify(state.user.isAuthenticated))
        },
        UNSET_USER(state) {
            state.isAuthenticated = false;
            // localStorage.setItem("uid",JSON.stringify(state.user.uid))
            // localStorage.setItem("isAuthenticated",JSON.stringify(state.user.isAuthenticated))
        },
        SET_UNSCRIBEAUTH(state, payload) {
            state.unsubscribeAuth = payload
        }
    }
    , actions: {
        //воспользуйся тут axios
        INIT_AUTH({dispatch, commit, state}) {
            return new Promise((resolve) => {
                dispatch('STATE_CHANGED', state.isAuthenticated)
                let unsubscribe = state.isAuthenticated
                resolve(state.isAuthenticated)
                commit('SET_UNSCRIBEAUTH', unsubscribe)
                // console.log(isUserAuthenticated)
            });


        },
        SIGN_IN({commit, dispatch}, payload) {
            commit('SET_PROCESSING', true)
            commit('CLEAN_ERROR')
            dispatch('SEND_REQUEST_GET', payload)
                .then(resolve => {
                    if (resolve!='') {
                        console.log('answwer ', resolve)
                        commit('SET_USER', resolve)
                        commit('SET_PROCESSING', true)
                        commit('CLEAN_ERROR')
                        console.log(localStorage.getItem('isAuthenticated'))
                        payload.statusEnter()
                    }
                    else
                    {
                        payload.statusErr()
                    }

                    }
                )

        },

        STATE_CHANGED({commit}, payload) {

            if (payload == true) {

            } else
                commit('UNSET_USER')
        },
        SIGN_OUT({commit}) {
            //выход\
            commit('UNSET_USER')
            commit('SET_PROCESSING', false)

        }
    },
    getters: {
        //первый способ
        // isAuthenticated(state) {
        //     return state.isAuthenticated
        // }
        // Второй способ
        getUser:(state)=>state.user,
        isUserAuthenticated: (state) => state.isAuthenticated
    }
}