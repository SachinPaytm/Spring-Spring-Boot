import React,{useState} from 'react';
import {useNavigate} from 'react-router-dom';
import {useAuth} from './AuthContext.js'

export default function LoginComponent(){
    const [username,setUsername] = useState('admin')
    const [password,setPassword] = useState('')
    const [showSuccessMessage,setShowSuccessMessage] = useState(false);
    const [showErrorMessage,setShowErrorMessage] = useState(false);
    const navigate = useNavigate()
    const auth = useAuth()
    function handleUsernameChange(param){
        setUsername(param.target.value)
    }
    function handlePasswordChange(param){
        setPassword(param.target.value)
    }
    function handleLogin(){
        if(auth.login(username,password)){
            navigate(`/welcome/${username}`)
        }
        else{
            setShowErrorMessage(true)
        }
    }


    return (
    <>
        <h1> Login</h1>
        <div className="Login">
            {showErrorMessage && <div className="errorMessage"><h2>Authentication Failed.
                                                                Please check your credentials.</h2></div>}
            <div className="LoginForm">
                <div>
                    <label> Username: </label>
                    <input type="text" name="username"  value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label> Password: </label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleLogin}> Login </button>
                </div>
            </div>
        </div>
    </>
    )
}

