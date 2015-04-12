Reveal.js custom build

## Why ?

Because I want a custom tailored workflow that enables me to use (and fully control) svg in my reveal.js slides

#Setup

1. Install [Node.js](http://nodejs.org/)

2. Install [Grunt](http://gruntjs.com/getting-started#installing-the-cli)

4. Clone the repository

5. Navigate to the reveal.js folder
   ```sh
   $ cd reveal.js
   ```

6. Install dependencies
   ```sh
   $ npm install
   ```

7. Serve the presentation and monitor source files for changes
   ```sh
   $ grunt serve
   ```
 

# Author
## SVGs

Files added to `/svg` directory are converted to an svg sprite an is directly included in the `<body>`

If the file name is `/svg/laptop126.svg` you can refert to it simply with :

	<svg> <use xlink:href="#shape-laptop126"/> </svg>

The reason to have all the svg in the body is to have full access to it (styling/scripting)

## Slides
Slides are édited in a partial file : 
	
	/author/slides.html

## Javascript
You can customize behaviour  simply by editing 

	
	/author/custom.js

