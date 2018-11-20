import React, { Component } from "react";
import {
  FormGroup,
  ControlLabel,
  FormControl,
  Checkbox,
  Button
} from "react-bootstrap";
import styled from "styled-components";

class RegisterForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      id: "",
      ladders: props.ladders.map(ladder => {
        const obj = {
          name: ladder.name,
          isSelected: false
        };
        return obj;
      })
    };
  }

  updateName(event) {
    const newName = event.target.value;
    this.setState({ name: newName });
  }

  updateId(event) {
    const newId = event.target.value;
    this.setState({ id: newId });
  }

  updateCheckbox(event) {
    const { checked, name } = event.target;
    const ladders = this.state.ladders;
    const index = ladders.findIndex(ladder => {
      return ladder.name === name;
    });
    this.setState(prevState => ({
      ...prevState,
      ladders: prevState.ladders.map((ladder, i) => {
        if (i === index) {
          return Object.assign(ladder, { isSelected: checked });
        } else {
          return ladder;
        }
      })
    }));
  }

  onSubmit(event) {
    const ladders = this.state.ladders;
    const selectedLadders = ladders.filter(ladder => {
      return ladder.isSelected;
    });
    const message = {
      command: "add",
      name: this.state.name,
      ladders: selectedLadders
    };
    this.props.onSubmit(message);
  }

  render() {
    return (
      <RegisterWindow>
        <Caption>Register</Caption>
        <form>
          <FormGroup controlId="formBasicText">
            <ControlLabel>Name</ControlLabel>
            <FormControl
              type="text"
              autocomplete="off"
              value={this.state.name}
              placeholder="Enter your name"
              onChange={event => this.updateName(event)}
            />
          </FormGroup>
          <FormGroup controlId="formBasicText">
            <ControlLabel>Membership ID</ControlLabel>
            <FormControl
              type="number"
              autocomplete="off"
              value={this.state.id}
              placeholder="Enter your membership ID"
              onChange={event => this.updateId(event)}
            />
          </FormGroup>
          <FormGroup>
            <ControlLabel>Select the ladders you want to join</ControlLabel>
            {this.state.ladders.map((ladder, index) => {
              return (
                <Checkbox
                  onChange={event => this.updateCheckbox(event)}
                  name={ladder.name}
                  key={index}
                >
                  {ladder.name}
                </Checkbox>
              );
            })}
          </FormGroup>
          <Button type="submit" onClick={event => this.onSubmit(event)}>
            Submit
          </Button>
        </form>
      </RegisterWindow>
    );
  }
}
const Caption = styled.p`
  text-align: center;
`;

const RegisterWindow = styled.div`
  width: 90%;
  margin: 0 auto;
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  padding: 2rem;
  margin-top: 2rem;
`;

export default RegisterForm;
