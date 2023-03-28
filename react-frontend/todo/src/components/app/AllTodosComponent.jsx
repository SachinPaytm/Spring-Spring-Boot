import React,{useState,useEffect,useContext} from 'react'
import {useNavigate} from 'react-router-dom';
import {getAllTodosApi,deleteTodoApi,updateTodoApi} from './api/TodoApi'
import {AuthContext} from './AuthContext.js';

export default function AllTodosComponent(){

    const useAuth = useContext(AuthContext)
    const username = useAuth.username

    const [todos,setTodos] = useState([])
    const [message,setMessage] = useState(null)

    const navigate = useNavigate()

    useEffect(
        () => refreshTodos(),[]
    )

    function refreshTodos(){
        getAllTodosApi(username)
            .then((response)=> setTodos(response.data) )
            .catch((error)=> console.log(error))
    }

    function deleteAndRefreshTodos(id){
        setMessage(`Deleted todo ${id}`)
        refreshTodos()
    }

    function deleteTodo(id){
        console.log(`Deleting todo ${username} &  ${id}`)
        deleteTodoApi(username,id)
        .then(
            () => deleteAndRefreshTodos(id)
         )
        .catch((error)=> console.log(error))
    }

    function updateTodo(id){
        console.log(`Updating todo ${username} &  ${id}`)
        navigate(`/todos/${id}`)
    }

    function addNewTodo(){
        navigate(`/todos/-1`)
    }
   return (
       <div className="container">
            <h1>
                Your Todos
            </h1>
            {message && <div> {message}</div>}
            <div>
                <table className="table">
                       <thead>
                            <tr>
                                <th> Description</th>
                                <th> Done? </th>
                                <th> Target Date</th>
                                <th> Delete </th>
                                <th> Update </th>
                            </tr>
                       </thead>
                            {
                            todos.map(

                                todo => (
                                <tr key={todo.id}>
                                        <td> {todo.description}</td>
                                        <td> {todo.done.toString()}  </td>
                                        <td> {todo.targetDate.toString()}</td>
                                        <td> <button className="btn btn-warning" onClick={ () => deleteTodo(todo.id) } > Delete Todo </button> </td>
                                        <td> <button className="btn btn-success text-black" onClick={ () => updateTodo(todo.id) } > Update Todo </button> </td>
                                </tr>
                                )
                            )}

                          <tbody>
                       </tbody>
               </table>
            </div>
            <div className="btn btn-success m-4" onClick={addNewTodo}> Add a new todo </div>
       </div>
   )
}