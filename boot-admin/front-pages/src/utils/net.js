import axios from 'axios'
import router from '../router'

const http = {
     /** 
     * axios http
     */
    request: function (options) {
        let opts = options ? options : {};
        return new Promise((resolve, reject) => {
            axios.request(opts)
            .then((response) => {
                resolve(response.data);
            })
            .catch((error) => {
                reject(error);
            });
        });
    },
    get: function (url, params) {
        return new Promise((resolve, reject) => {
            axios.get(url, {params: params})
            .then((response) => {
                resolve(response.data);
            })
            .catch((error) => {
                reject(error);
            });
        });
    },
    post: function (url, params) {
        return new Promise((resolve, reject) => {
            axios.post(url, params)
                .then((response) => {
                    resolve(response.data);
                })
                .catch((error) => {
                    reject(error);
                });
        })
    },

    /** 
     * vue router
     */
    push:function(options){
        router.push(options);
    },
    route: function(url, params) {
        router.push({ path: url, query: params });
    },
    redirect: function(url) {
        document.location = url;
    },
    goBack: function(index) {
        if (index === undefined || index === null) {
            router.go(-1);
        } else {
            router.go(index);
        }
    },
    go: function(index) {
        router.go(index);
    }
};

export default http
