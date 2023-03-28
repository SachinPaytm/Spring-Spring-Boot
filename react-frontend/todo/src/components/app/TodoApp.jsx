
import React from 'react';
import {BrowserRouter,Route,Routes,Navigate} from 'react-router-dom';
import Header from './Header'
import Footer from './Footer'
import Logout from './Logout'
import LoginComponent from './Login'
import WelcomeComponent from './WelcomeComponent'
import ErrorComponent from './ErrorComponent'
import TodoComponent from './TodoComponent'
import AllTodosComponent from './AllTodosComponent'
import './TodoApp.css'
import AuthProvider,{useAuth} from  './AuthContext'

function IsAuthenticatedRoute({children}) {
    const authContext = useAuth()

    if(authContext.isAuthenticated)
        return children

    return <Navigate to="/" />
}


export default function TodoApp(){
    return (
    <div className="TodoApp">
        <AuthProvider>

        <BrowserRouter>
                <Header/>
                <Routes>
                    <Route path='/' element={ <LoginComponent /> } />
                    <Route path='/login' element={ <LoginComponent /> } />

                    <Route path='/welcome/:username' element={ <IsAuthenticatedRoute> <WelcomeComponent /> </IsAuthenticatedRoute> } />

                    <Route path='/todos' element={ <IsAuthenticatedRoute> <AllTodosComponent/> </IsAuthenticatedRoute>} />

                    <Route path='/todos/:id' element={ <IsAuthenticatedRoute> <TodoComponent/> </IsAuthenticatedRoute>} />

                    <Route path='/logout' element={ <IsAuthenticatedRoute> <Logout/> </IsAuthenticatedRoute>} />

                    <Route path='*' element={<ErrorComponent /> } />
                </Routes>
{/*                 <Footer/> */}
        </BrowserRouter>
          </AuthProvider>

    </div>
   )
}
