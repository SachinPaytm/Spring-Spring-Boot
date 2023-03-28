import {apiClient} from './ApiClient';


export const getHelloWorldApi
   = () => apiClient.get("/hello-world-bean")

export const getHelloWorldBeanApi
   = () => apiClient.get("/hello-world-bean")

export const getHelloWorldBeanPathVariableApi
   = (username,token) => apiClient.get(`/hello-world/path-variable/${username}`)

