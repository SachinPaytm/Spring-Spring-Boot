import React,{ createContext, useContext, useState } from "react";
import {executeBasicAuthenticationService,executeJwtAuthenticationService} from './api/AuthenticationApi'
import {apiClient} from './api/ApiClient'


export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)


export default function AuthProvider({ children }) {
    const [isAuthenticated, setAuthenticated] = useState(false)

    const [username, setUsername] = useState(null)

    const [token, setToken] = useState(null)

    async function login(username, password) {
        console.log(username)
            try{
                const response = await executeJwtAuthenticationService(username,password)
                console.log(response)
                if(response.status==200){
                    const jwtToken = 'Bearer '+ response.data.token
                    console.log(jwtToken)

                    setToken(jwtToken)
                    setAuthenticated(true)
                    setUsername(username)

                    apiClient.interceptors.request.use(
                        (config) => {
                            console.log("token added to all urls")
                            config.headers.Authorization = jwtToken
                            return config
                        }
                    )
                    return true
                } else {
                    logout()
                    return false
                }
            }
            catch(error ){
                logout()
              return false
            }


     }

/*

     async function login(username, password) {
        try{
            const baToken = "Basic "+ window.btoa(username+":"+password)
            const response = await executeBasicAuthenticationService(baToken)

            if(response.status==200){
                console.log(response)
                console.log(baToken)

                setToken(baToken)
                setAuthenticated(true)
                setUsername(username)

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log("token added to all urls")
                        config.headers.Authorization = baToken
                        return config
                    }
                )
                return true
            } else {
                logout()
                return false
            }
        }
        catch(error ){
            logout()
          return false
        }


     }
          function login(username, password) {
              if(username==='admin' && password==='password'){
                  setAuthenticated(true)
                  setUsername(username)
                  return true
              } else {
                  setAuthenticated(false)
                  setUsername(null)
                  return false
              }
          }
*/

    function logout(){
        setUsername(null)
        setAuthenticated(false)
        setToken(null)
    }
    return (
        <AuthContext.Provider value={ {isAuthenticated, username, token,login,logout}  }>
            {children}
        </AuthContext.Provider>
    )
}