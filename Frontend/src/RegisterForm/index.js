import React, { Component } from "react";
import {
  FormGroup,
  ControlLabel,
  FormControl,
  Checkbox,
  Button,
  HelpBlock
} from "react-bootstrap";
import { Window, Caption, Hr } from "../Components";

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
      }),
      nameValidation: null,
      idValidation: null,
      ladderValidation: null
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
    this.setState(prevState => ({
      ...prevState,
      ladders: prevState.ladders.map(ladder => {
        if (ladder.name === name) {
          return Object.assign(ladder, { isSelected: checked });
        } else {
          return ladder;
        }
      })
    }));
  }

  canSubmit(event, selectedLadders) {
    const nameLength = this.state.name.length;
    const idLength = this.state.id.length;
    if (nameLength > 0 && selectedLadders.length > 0 && idLength > 0) {
      return true;
    } else {
      event.preventDefault();
      this.validateNameLength();
      this.validateId();
      this.validateSelectedLadders(selectedLadders);
      return false;
    }
  }

  validateNameLength() {
    const length = this.state.name.length;
    this.setState({ nameValidation: length === 0 ? "error" : null });
  }

  validateId() {
    const length = this.state.id.length;
    this.setState({ idValidation: length === 0 ? "error" : null });
  }

  validateSelectedLadders(selectedLadders) {
    const length = selectedLadders.length;
    this.setState({ ladderValidation: length === 0 ? "error" : null });
  }

  onSubmit(event) {
    const ladders = this.state.ladders;
    const selectedLadders = ladders
      .filter(ladder => {
        return ladder.isSelected;
      })
      .map(ladder => {
        return { name: ladder.name };
      });

    const message = {
      command: "add",
      name: this.state.name,
      ladders: selectedLadders
    };
    if (this.canSubmit(event, selectedLadders)) {
      this.props.onSubmit(message);
    }
  }

  render() {
    return (
      <Window>
        <Caption>Register</Caption>
        <form>
          <FormGroup
            controlId="formName"
            validationState={this.state.nameValidation}
          >
            <ControlLabel>Name</ControlLabel>
            <FormControl
              type="text"
              autoComplete="off"
              value={this.state.name}
              placeholder="Enter your name"
              onChange={event => this.updateName(event)}
            />
            <FormControl.Feedback />
            {this.state.nameValidation === "error" ? (
              <HelpBlock>Enter a name of at least one character</HelpBlock>
            ) : null}
          </FormGroup>
          <FormGroup
            controlId="formId"
            validationState={this.state.idValidation}
          >
            <ControlLabel>Membership ID</ControlLabel>
            <FormControl
              type="number"
              autoComplete="off"
              value={this.state.id}
              placeholder="Enter your membership ID"
              onChange={event => this.updateId(event)}
            />
            <FormControl.Feedback />
            {this.state.idValidation === "error" ? (
              <HelpBlock>Enter an id of length at least one</HelpBlock>
            ) : null}
          </FormGroup>
          <FormGroup
            controlId="formLadder"
            validationState={this.state.ladderValidation}
          >
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
            <FormControl.Feedback />
            {this.state.ladderValidation === "error" ? (
              <HelpBlock>Select at least one ladder</HelpBlock>
            ) : null}
          </FormGroup>
          <Hr />
          <Button type="submit" onClick={event => this.onSubmit(event)}>
            Submit
          </Button>
        </form>
      </Window>
    );
  }
}

export default RegisterForm;
