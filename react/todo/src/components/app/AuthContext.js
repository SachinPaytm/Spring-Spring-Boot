import React,{ createContext, useContext, useState } from "react";

export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

export default function AuthProvider({ children }) {
    const [isAuthenticated, setAuthenticated] = useState(false)

    const [username, setUsername] = useState(null)

    const [token, setToken] = useState(null)

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

    function logout(){
        setAuthenticated(false)
    }
    return (
        <AuthContext.Provider value={ {isAuthenticated, username, token,login,logout}  }>
            {children}
        </AuthContext.Provider>
    )
}