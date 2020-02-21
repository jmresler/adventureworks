import React, { Component} from "react";
import PropTypes from "prop-types";
import { Form, Button } from "react-bootstrap";


export default class SignonForm extends Component {

    constructor(props) {
        super(props);

        this.state = {
            email:'',
            password:''
        }
    }


    render() {
        return (
        <Form>
            <Form.Group controlId="formBasicEmail">
                <Form.Label style={{padding:5}}>Email address <i className="fa fa-envelope-o"></i></Form.Label>
                <Form.Control type="email" placeholder="Enter email" required />
                <Form.Text className="text-muted">
                    We do not share your email with anyone else.
                </Form.Text>
            </Form.Group>
            <Form.Group controlId="formBasicPassword">
                <Form.Label>Password<i className="fa fa-lock" style={{padding:5}}></i></Form.Label>
                <Form.Control type="password" placeholder="Password"  required/>
            </Form.Group>
            <Form.Group controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="Remember me"/>
            </Form.Group>
            <Button variant="primary" type="submit">
                Sign On
            </Button>
        </Form>
        );
    }
}

SignonForm.props = {
    email: PropTypes.string.isRequired,
    password: PropTypes.string.isRequired 
}