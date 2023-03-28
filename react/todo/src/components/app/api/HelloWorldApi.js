import axios from 'axios';
export const getHelloWorldApi
   = () => axios.get("http://localhost:8080/hello-world-bean")
