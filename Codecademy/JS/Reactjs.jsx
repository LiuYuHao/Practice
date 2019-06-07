// JSX is a syntax extension for JavaScript. It was written to be used with React
// If a JavaScript file contains JSX code, then that file will have to be compiled.
// That means that before the file reaches a web browser, a JSX compiler will translate any JSX into regular JavaScript.
// html allowed
<p>hello world</p> // an exmaple of jsx element
// combine with JavaScript
const variable = <p>hello world</p> // JSX an exrension for JavaScript. Written with react
// jsx element are treated as JS expression, therefore, it can be saved in a variable, passed to function, stored in a object
// A JXS attribute : name="" html-like syntax
const title = <h1 id="title">Introduction to React.js: Part I</h1>;
// can have many attribute like html
// nested jsx like <a><p></p></a>
// only one outermost element, mean a const = only one tag.
// rendering jsx - make element apear on screen
// ReactDOM is the name of js library, there are series of react methods, all deals with DOM
// render() is render jsx, two argument, first argument is the thing u want to display and second element is where you want to display
// ReactDOM.render(<h1>Render me!</h1>, document.getElementById('container'));
// passing a varible, first element can be a variable
const myList = (
      <ul>
        <li>1</li>
        <li>2</li>
      </ul>
  );
// pass this to first argument
// ReactDOM only update DOM element that have changed, it means adding two hello, at the same ID the second render will not do anything
// The class attribute, in html class = className in jsx
// self closing tag - there are some tag without closing tag, like img, therefore we need to <img />
// convert between jsx and regular js is {}, the thing in {} is considered as regular js
// variable is able to access in js
const name = "hi";
const green = <h1>hi {name}</h1>;
// can use variable to set the Attributes
// event listeners in lsx, onClick, onMouseOver, https://reactjs.org/docs/events.html#supported-events
function makeDoggy(e) {
  // Call this extremely useful function on an <img>.
  // The <img> will become a picture of a doggy.
  e.target.setAttribute('src', 'https://s3.amazonaws.com/codecademy-content/courses/React/react_photo-puppy.jpeg');
  e.target.setAttribute('alt', 'doggy');
}

const kitty = (
	<img
		src="https://s3.amazonaws.com/codecademy-content/courses/React/react_photo-kitty.jpg"
		alt="kitty" onClick={makeDoggy}/>
);
// the effect is onlick the image will lead to another image which src is in the function
// if statment is not allow in {}
// make a if statment but it is not happen in render.
// the ternary operator ? is work on the jsx inside of {}
// &&, this can help to display some tag under some condition { condition && tag}
// the function .map is work on jsx
// the key attribute in jsx is meaning the value is unique, like id in html, it is use for internally to keep track of list, like memeory list, when u need it
// React.createElement - create html tag in the jsx, which u can write react code without writing react.
// const greatestDivEver = React.createElement("div",null,"i am div");
///////////////
//////////
////////////////
// Component - a small, reuseable chunk of code (class)
// import is like create a varaible to represent the library or tool
// requre a component class - create from base class of react extends React.Component
// render() {} - function
// a render function must include a return, return a jsx experssion
// the way to create a instance of the class is <name />
class MyComponentClass extends React.Component {
  render() {
    return <h1>Hello world</h1>;
  }
}
//muti-line JSX expression must be inside of ()
// we can use variable attribute in class also logical expression
// render is also a place for you to put some calcualtion before component is happened
// we can use logic, condition and so on.
// we can use this since it is a class.
// include a event listeners
class Button extends React.Component {
  scream() {
    alert('AAAAAAAAHHH!!!!!');
  }

  render() {
    return <button onClick={this.scream}>AAAAAH!</button>; // scream or scream()
  }
}
// components interact
// the interaction is simple, just call the class name <name /> on the other class return
// import "./" means this as file path not a lirbary or
// when use named export, we must need to use {}
//////////////////////////////////////////////////
// This.props - passing information to another component
// every component has props - a object uses for holding the imformation about that component
// <MyComponent foo="bar" /> a exmaple for how to passing to props,if the information is not string must need to wrap with {}
// {[1,2,34]}
// the display {"myProp":"Hello"}, if we passing those hello to myProp and <h2>{this.props}</h2>
// using import and export between the component.
// using codition with pros to display different UI.
// passing function to props, name() {} represent fucntion in component class
// this.nameoffunction
// then on otherside, we need to receive it by add the attribute this.props.talk
// name propety like onClick, onKeyClick,
// notes: onClick on html-like js is create a event listener, where as in component it just a name
// props.children will return  everything in between a component's opening and closing JXS tag
// children = the content of <name>content </name>
// default props, default props should equal to an object, and right name: value inside of it
// name.defaultProps = {name:value} under the class.
//////////////////////////////////////////////////////
// this.state - dynamic information
// state is inside of construtor, it is not from outside (arguemnt)
// state is mutable, and slow and should not pass to children.
// there is setstate to update the state, usually wrap by a function this.setState({name:value})
// everytime, when we need to create a event handler, we need to this.methodname =this.methodName.bind(this), since function contains this
// a great example using state to change background color
const green = '#39D1B4';
const yellow = '#FFD712';

class Toggle extends React.Component {
  constructor(props) {
    super(props);
    this.state = {color:green};
    this.changeColor = this.changeColor.bind(this);
  }
  changeColor() {
    const newColor = this.state.color == 'green' ? 'yellow' : 'green';
    this.setState({ color: newColor });
  }
  render() {
    return (
      <div style={{background: this.state.color}}>
        <h1>
          <button onClick={this.changeColor}>
          Change my color
          </button>
        </h1>
      </div>
    );
  }
}

ReactDOM.render(<Toggle/>,document.getElementById('app'))
// setState auto called render fucntion again, see example above, duo to we only change color but we didn't render one more time manual.
// how the screen change? answer is set state auto call render function
