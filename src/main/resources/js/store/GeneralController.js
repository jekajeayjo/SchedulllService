import Vue from 'vue'
import axios from "axios";
import VueAxios from "vue-axios";

Vue.use(VueAxios, axios)
export default {
    state: {
        data: null,
        error: null,
        processing: false,
    },
    mutations: {
        SET_PROCESSING(state, payload) {
            state.processing = payload
        },
        SET_DATA(state, payload) {
            state.data = payload
        },
        SET_ERROR(state, payload) {
            state.error = payload
        },
        CLEAN_ERROR(state) {
            state.error = null
        }

    },
    actions: {
        SEND_REQUEST_GET({commit}, payload) {
            let urlPath='/testsceduler';
            // console.log('main payload',payload)
            return new Promise((resolve, reject) => {
                Vue.axios.get(urlPath+payload.url)
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp.data)
                        // commit('SET_DATA', resp.data)
                        resolve(resp.data)

                    }).catch(err => {
                    commit('SET_ERROR', 'Ошибка подключения')
                    console.log('error connect')
                    reject(err)
                })
            });
        },
        SEND_REQUEST_POST({commit}, payload) {
            console.log("POST",payload)
            // console.log('main payload',payload)
            return new Promise((resolve, reject) => {
                Vue.axios.post(payload.url, payload.data)
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp)
                        resolve(resp.data)
                    }).catch(err => {
                    reject(err)
                })
            });
        },
        SEND_REQUEST_DELETE({commit}, payload) {
            // console.log('main payload',payload)
            return new Promise((resolve, reject) => {
                Vue.axios.delete(payload.url)
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp.data)
                        // commit('SET_DATA', resp.data)
                        resolve(resp.data)

                    }).catch(err => {
                    commit('SET_ERROR', 'Ошибка подключения')
                    console.log('error connect')
                    reject(err)
                })
            });
        },
        // Получение списка
        GET_ROWS({commit, dispatch}, payload) {
            dispatch('SEND_REQUEST_GET', payload)
                .then(resolve => {
                        console.log('GET_ROWS', resolve)
                        commit('CLEAN_ERROR')
                        payload.showRows(resolve)

                    }
                )
        },
    },
    getters: {
        getData: (state) => state.data,
        getError: (state) => state.error
    }
}