# Hoc Habet ELO ladder system
This is the ladder system that will be used by E.S.S.V. Hoc Habet (Student fencing club). 
The system will be split into a frontend and a backend, the frontend will be integrated in the already existing website of Hoc Habet.
The backend will be run at the server of Hoc Habet.

## Getting started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Frontend:

* Not yet determined

Backend:

* Java 8 - download the JDK [here](https://www.oracle.com/technetwork/java/javase/downloads/index.html), if not done so already
* Your preferred IDE - for example, [intellij](https://www.jetbrains.com/idea/download/) (Windows, MacOS, Linux)

Documentation:

* LaTeX installation - for example, [TeX live](https://www.tug.org/texlive/acquire-netinstall.html)
* LaTex editor - for example, [TEX Maker](http://www.xm1math.net/texmaker/) (Windows, MacOS, Linux)

## Contributing
TODO.

## Project structure

### Frontend
A frontend written in [React.js](https://reactjs.org/). Communicates through a WebSocket connection with the backend. The frontend is responsible for showing all the relevant information to the user, i.e. all the ladders for for all the weapons, and ways to interact with the ladder.

### Backend
The backend is a java server handling all the relevant work, e.g. accepting new connections from the frontend, processing requests, updating the database of the registered fencers, and updating the ladder representation inside memory.  

### Documentation

The folder containing the documentation with the setup, rules, etc. of the ladder competition. Used for reference to implement the system.

## Authors
* **Stefan Tanja** - Treasurer Hoc Habet 2018-2019 - [satanja](https://github.com/satanja)
* **Bob Booij-Liewes** - Chairman Hoc Habet 2018-2019 - [BBooijLiewes](https://github.com/BBooijLiewes)
* **Hidde Koerts** - Administrative Officer Hoc Habet 2018-2019 - [HiddeKoerts](https://github.com/HiddeKoerts)

## Acknowledgements
* The board of Hoc Habet 2018-2019
* Everyone else who gave input on deciding how to implement the ladder