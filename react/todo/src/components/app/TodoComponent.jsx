import React from 'react'

export default function TodoComponent(){

    const todos = [{"id":1,"description":"Learn Spring"},
                    {"id":2,"description":"Learn Docker"},
                    {"id":3,"description":"Learn Java"}
                   ]

   return (
       <div className="TodoComponent">
            <div>
                Your Todos
            </div>
            <div>
                <table>
                   <thead>
                        <tr>
                            <td> Id</td>
                            <td> Description</td>
                        </tr>
                   </thead>
                        {
                        todos.map(

                            todo => (
                                <tr key={todo.id}>
                                <td> {todo.id}  </td>
                                <td> {todo.description}</td>
                            </tr>
                            )
                        )}

                   <tbody>
                   </tbody>
               </table>
           </div>
       </div>
   )
}