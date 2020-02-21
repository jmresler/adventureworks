import React, {Component} from "react";
import { Form, Button } from "react-bootstrap";


export default class FeedbackForm extends Component {
    
    constructor(props) {
        super(props);
        this.state = {
            hasError: false,
            email:'',
            subject:'',
            comments : '',
            strikes : 0
        }

        this.onKeyPress = this.onKeyPress.bind(this);
        this.submitForm = this.submitForm.bind(this);
    }

    componentDidMount() {

    }

    onKeyPress = (event) => {

        if (event.which === 13) {
            this.submitForm();
        }

        if (event.target.name === 'email') {
            this.setState({email : event.target.value});
        } else if (event.target.name === 'subject') {
            this.setState({subject:event.target.value});
        } else if (event.target.name === 'comments') {
            this.setState({comments:event.target.value});
        }
    }

    submitForm = () => {

    }

    render() {

        let commentsStyle = {width:"100%", resize:"none", height:150};

        return (
            <>
                <Form>
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label style={{padding:5}}>Email address <i className="fa fa-envelope-o"></i></Form.Label>
                        <Form.Control type="email" placeholder="Enter email" required onKeyPress={this.onKeyPress} name="email"/>
                        <Form.Text className="text-muted">
                            <em>We do not share your email with anyone else.</em>
                        </Form.Text>
                    </Form.Group>
                    <Form.Group controlId="formBasicFeedbackSubject">
                        <Form.Label style={{padding:5}}>Subject</Form.Label>
                        <Form.Control type="text" placeholder="Subject" required onKeyPress={this.onKeyPress} name="subject"/>                        
                    </Form.Group>
                    <Form.Group controlId="formBasicFeedbackMessage">
                        <Form.Label style={{padding:5}}>Message</Form.Label>
                        <textarea id="comments" 
                                  name="comments" 
                                  placeholder="Comments" 
                                  style={commentsStyle} 
                                  required 
                                  onKeyPress={this.onKeyPress}
                                  maxLength="2048"></textarea>                        
                    </Form.Group>                    
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </>
        );
    }
}