import React,{useContext,useEffect,useState} from 'react';
import {useParams,useNavigate} from 'react-router-dom'
import {getTodoApi,updateTodoApi,createTodoApi} from './api/TodoApi.js';
import {AuthContext} from './AuthContext.js';
import {Formik,Form,Field,ErrorMessage} from 'formik';
import moment from 'moment'

export default function TodoComponent(){
    const auth = useContext(AuthContext)
    const username = auth.username

    const [description,setDescription] = useState(null)
    const [targetDate,setTargetDate] = useState(null)

    const {id} = useParams()

    const navigate = useNavigate()


    useEffect(
        () =>  getTodo(), [id]
    )

    function getTodo(){
        if(id!=-1){
            getTodoApi(username,id)
                .then((response) => {
                    setDescription(response.data.description)
                    setTargetDate(response.data.targetDate)
                })
                .catch((error) => console.log(error))
        }
    }

    function onSubmit(values){
        const todo = {
            id:id,
            username:username,
            description:values.description,
            targetDate:values.targetDate,
            done:false
        }
        console.log(values)
        if(id==-1){
            createTodoApi(username,todo)
            .then((response) => {
                navigate("/todos")
            })
            .catch((error) => console.log(error))
        }
        else{
            updateTodoApi(username,id,todo)
            .then((response) => {
                navigate("/todos")
            })
            .catch((error) => console.log(error))
        }
    }

    function validate(values){
        var errors = {
        }

        if(values.description.length < 8){
            errors.description="Enter atleast 8 characters"
        }
        if(!moment(values.targetDate).isValid() || values.targetDate==null || values.targetDate==''){
            errors.targetDate="Enter valid date"
        }
        return errors
    }

    return (
        <div className="TodoComponent">
        <h1>Type your details</h1>
        <div>

            <Formik initialValues={{description , targetDate}}
                    enableReinitialize={true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
            >
            {
                (props) => (
                    <Form>
                        <ErrorMessage name="description" component="div" className="alert alert-warning" />

                        <ErrorMessage name="targetDate" component="div" className="alert alert-warning" />

                        <fieldSet className="form-group">
                            <label> Description </label>
                            <Field type="text" className="form-control" name="description" />
                        </fieldSet>

                        <fieldSet className="form-group">
                            <label> Target Date </label>
                            <Field type="date" className="form-control" name="targetDate" />
                        </fieldSet>
                        <button className="btn btn-success m-4" type = "submit"> Submit </button>
                    </Form>
                )
            }
            </Formik>

        </div>

        </div>
    )
}