# Frontend
## Requirements
* [Node.js](https://nodejs.org/en/download/) (Windows, Linux, MacOS)
* [yarn](https://yarnpkg.com/en/docs/install) (Windows, Linux, MacOS). Using npm from Node.js is fine as well, but yarn is slightly faster among other reasons.

## Setup
1. install yarn in `~/Frontend/`:
    ```
    $ yarn
    ```
2. install `styled-components`:
    ```
    $ yarn add styled-components
    ```
3. install React-Bootstrap:
    ```
    $ yarn add react react-dom
    $ yarn add react-bootstrap
    ```
## Structure
React.js is a javascript library oriented around components. All folders in `src` belong to specific components.
* Ladder The component that returns a table with all the fencers received from the backend
* IO The component that handles all the requests and responses *(to implement)* 