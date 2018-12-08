import styled from "styled-components";

const Caption = styled.p`
  text-align: center;
`;

const Window = styled.div`
  width: 90%;
  margin: 0 auto;
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  padding: 2rem;
  margin-top: 2rem;
`;

const ErrorWindow = styled(Window)`
  background-color: #ff5454;
`;

const WarningWindow = styled(Window)`
  background-color: #ffa15e;
`;

const Hr = styled.hr`
  margin-top: 0;
  margin-bottom: 1rem;
`;
export { Caption, Window, Hr, ErrorWindow, WarningWindow };
