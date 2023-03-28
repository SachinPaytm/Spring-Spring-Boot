import React from 'react';
import {useParams,Link} from 'react-router-dom';
import {getHelloWorldApi,getHelloWorldBeanApi,getHelloWorldBeanPathVariableApi} from './api/HelloWorldApi'
import {AuthContext} from './AuthContext'


export default function WelcomeComponent(){
   const {username} = useParams();
    const auth = React.useContext(AuthContext)
    function goToHelloWorldRestApi(){
        getHelloWorldBeanPathVariableApi(username,auth.token)
            .then((response)=> successResponse(response))
            .catch((error)=> errorResponse(error))
            .finally(()=>console.log("finish"))
    }
    function successResponse(response){
        console.log(response)
        return response
    }
    function errorResponse(error){
        console.log(error)

        return error
    }
   return (
   <div className="WelcomeComponent">
       <h1>Welcome {username}!!</h1>
       <div>
           Manage Your <Link to="/todos" > Todos </Link>
       </div>
       <div>
            <button className="btn btn-success m-3" type="button" onClick={goToHelloWorldRestApi}>Go to Hello World</button>
       </div>
   </div>
   )
}
