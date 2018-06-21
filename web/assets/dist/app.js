/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./webpack/webpack.bootstrap.js");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./js/url-form.js":
/*!************************!*\
  !*** ./js/url-form.js ***!
  \************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var urlForm = document.querySelector('.url-form');
var passwordCheckbox = urlForm.querySelector('#passwordProtected');
var passwordCheckboxLabel = urlForm.querySelector('label[for=passwordProtected]');
var passwordField = urlForm.querySelector('#password');
$(passwordCheckbox).click(function (e) {
  passwordCheckbox.checked ? passwordField.style.display = 'block' : passwordField.style.display = 'none';
});

/***/ }),

/***/ "./node_modules/node-libs-browser/mock/empty.js":
/*!******************************************************!*\
  !*** ./node_modules/node-libs-browser/mock/empty.js ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {



/***/ }),

/***/ "./node_modules/os-browserify/browser.js":
/*!***********************************************!*\
  !*** ./node_modules/os-browserify/browser.js ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

exports.endianness = function () { return 'LE' };

exports.hostname = function () {
    if (typeof location !== 'undefined') {
        return location.hostname
    }
    else return '';
};

exports.loadavg = function () { return [] };

exports.uptime = function () { return 0 };

exports.freemem = function () {
    return Number.MAX_VALUE;
};

exports.totalmem = function () {
    return Number.MAX_VALUE;
};

exports.cpus = function () { return [] };

exports.type = function () { return 'Browser' };

exports.release = function () {
    if (typeof navigator !== 'undefined') {
        return navigator.appVersion;
    }
    return '';
};

exports.networkInterfaces
= exports.getNetworkInterfaces
= function () { return {} };

exports.arch = function () { return 'javascript' };

exports.platform = function () { return 'browser' };

exports.tmpdir = exports.tmpDir = function () {
    return '/tmp';
};

exports.EOL = '\n';

exports.homedir = function () {
	return '/'
};


/***/ }),

/***/ "./node_modules/path-browserify/index.js":
/*!***********************************************!*\
  !*** ./node_modules/path-browserify/index.js ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(process) {// Copyright Joyent, Inc. and other Node contributors.
//
// Permission is hereby granted, free of charge, to any person obtaining a
// copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to permit
// persons to whom the Software is furnished to do so, subject to the
// following conditions:
//
// The above copyright notice and this permission notice shall be included
// in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
// OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
// NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
// OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
// USE OR OTHER DEALINGS IN THE SOFTWARE.

// resolves . and .. elements in a path array with directory names there
// must be no slashes, empty elements, or device names (c:\) in the array
// (so also no leading and trailing slashes - it does not distinguish
// relative and absolute paths)
function normalizeArray(parts, allowAboveRoot) {
  // if the path tries to go above the root, `up` ends up > 0
  var up = 0;
  for (var i = parts.length - 1; i >= 0; i--) {
    var last = parts[i];
    if (last === '.') {
      parts.splice(i, 1);
    } else if (last === '..') {
      parts.splice(i, 1);
      up++;
    } else if (up) {
      parts.splice(i, 1);
      up--;
    }
  }

  // if the path is allowed to go above the root, restore leading ..s
  if (allowAboveRoot) {
    for (; up--; up) {
      parts.unshift('..');
    }
  }

  return parts;
}

// Split a filename into [root, dir, basename, ext], unix version
// 'root' is just a slash, or nothing.
var splitPathRe =
    /^(\/?|)([\s\S]*?)((?:\.{1,2}|[^\/]+?|)(\.[^.\/]*|))(?:[\/]*)$/;
var splitPath = function(filename) {
  return splitPathRe.exec(filename).slice(1);
};

// path.resolve([from ...], to)
// posix version
exports.resolve = function() {
  var resolvedPath = '',
      resolvedAbsolute = false;

  for (var i = arguments.length - 1; i >= -1 && !resolvedAbsolute; i--) {
    var path = (i >= 0) ? arguments[i] : process.cwd();

    // Skip empty and invalid entries
    if (typeof path !== 'string') {
      throw new TypeError('Arguments to path.resolve must be strings');
    } else if (!path) {
      continue;
    }

    resolvedPath = path + '/' + resolvedPath;
    resolvedAbsolute = path.charAt(0) === '/';
  }

  // At this point the path should be resolved to a full absolute path, but
  // handle relative paths to be safe (might happen when process.cwd() fails)

  // Normalize the path
  resolvedPath = normalizeArray(filter(resolvedPath.split('/'), function(p) {
    return !!p;
  }), !resolvedAbsolute).join('/');

  return ((resolvedAbsolute ? '/' : '') + resolvedPath) || '.';
};

// path.normalize(path)
// posix version
exports.normalize = function(path) {
  var isAbsolute = exports.isAbsolute(path),
      trailingSlash = substr(path, -1) === '/';

  // Normalize the path
  path = normalizeArray(filter(path.split('/'), function(p) {
    return !!p;
  }), !isAbsolute).join('/');

  if (!path && !isAbsolute) {
    path = '.';
  }
  if (path && trailingSlash) {
    path += '/';
  }

  return (isAbsolute ? '/' : '') + path;
};

// posix version
exports.isAbsolute = function(path) {
  return path.charAt(0) === '/';
};

// posix version
exports.join = function() {
  var paths = Array.prototype.slice.call(arguments, 0);
  return exports.normalize(filter(paths, function(p, index) {
    if (typeof p !== 'string') {
      throw new TypeError('Arguments to path.join must be strings');
    }
    return p;
  }).join('/'));
};


// path.relative(from, to)
// posix version
exports.relative = function(from, to) {
  from = exports.resolve(from).substr(1);
  to = exports.resolve(to).substr(1);

  function trim(arr) {
    var start = 0;
    for (; start < arr.length; start++) {
      if (arr[start] !== '') break;
    }

    var end = arr.length - 1;
    for (; end >= 0; end--) {
      if (arr[end] !== '') break;
    }

    if (start > end) return [];
    return arr.slice(start, end - start + 1);
  }

  var fromParts = trim(from.split('/'));
  var toParts = trim(to.split('/'));

  var length = Math.min(fromParts.length, toParts.length);
  var samePartsLength = length;
  for (var i = 0; i < length; i++) {
    if (fromParts[i] !== toParts[i]) {
      samePartsLength = i;
      break;
    }
  }

  var outputParts = [];
  for (var i = samePartsLength; i < fromParts.length; i++) {
    outputParts.push('..');
  }

  outputParts = outputParts.concat(toParts.slice(samePartsLength));

  return outputParts.join('/');
};

exports.sep = '/';
exports.delimiter = ':';

exports.dirname = function(path) {
  var result = splitPath(path),
      root = result[0],
      dir = result[1];

  if (!root && !dir) {
    // No dirname whatsoever
    return '.';
  }

  if (dir) {
    // It has a dirname, strip trailing slash
    dir = dir.substr(0, dir.length - 1);
  }

  return root + dir;
};


exports.basename = function(path, ext) {
  var f = splitPath(path)[2];
  // TODO: make this comparison case-insensitive on windows?
  if (ext && f.substr(-1 * ext.length) === ext) {
    f = f.substr(0, f.length - ext.length);
  }
  return f;
};


exports.extname = function(path) {
  return splitPath(path)[3];
};

function filter (xs, f) {
    if (xs.filter) return xs.filter(f);
    var res = [];
    for (var i = 0; i < xs.length; i++) {
        if (f(xs[i], i, xs)) res.push(xs[i]);
    }
    return res;
}

// String.prototype.substr - negative index don't work in IE8
var substr = 'ab'.substr(-1) === 'b'
    ? function (str, start, len) { return str.substr(start, len) }
    : function (str, start, len) {
        if (start < 0) start = str.length + start;
        return str.substr(start, len);
    }
;

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../process/browser.js */ "./node_modules/process/browser.js")))

/***/ }),

/***/ "./node_modules/process/browser.js":
/*!*****************************************!*\
  !*** ./node_modules/process/browser.js ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

// shim for using process in browser
var process = module.exports = {};

// cached from whatever global is present so that test runners that stub it
// don't break things.  But we need to wrap it in a try catch in case it is
// wrapped in strict mode code which doesn't define any globals.  It's inside a
// function because try/catches deoptimize in certain engines.

var cachedSetTimeout;
var cachedClearTimeout;

function defaultSetTimout() {
    throw new Error('setTimeout has not been defined');
}
function defaultClearTimeout () {
    throw new Error('clearTimeout has not been defined');
}
(function () {
    try {
        if (typeof setTimeout === 'function') {
            cachedSetTimeout = setTimeout;
        } else {
            cachedSetTimeout = defaultSetTimout;
        }
    } catch (e) {
        cachedSetTimeout = defaultSetTimout;
    }
    try {
        if (typeof clearTimeout === 'function') {
            cachedClearTimeout = clearTimeout;
        } else {
            cachedClearTimeout = defaultClearTimeout;
        }
    } catch (e) {
        cachedClearTimeout = defaultClearTimeout;
    }
} ())
function runTimeout(fun) {
    if (cachedSetTimeout === setTimeout) {
        //normal enviroments in sane situations
        return setTimeout(fun, 0);
    }
    // if setTimeout wasn't available but was latter defined
    if ((cachedSetTimeout === defaultSetTimout || !cachedSetTimeout) && setTimeout) {
        cachedSetTimeout = setTimeout;
        return setTimeout(fun, 0);
    }
    try {
        // when when somebody has screwed with setTimeout but no I.E. maddness
        return cachedSetTimeout(fun, 0);
    } catch(e){
        try {
            // When we are in I.E. but the script has been evaled so I.E. doesn't trust the global object when called normally
            return cachedSetTimeout.call(null, fun, 0);
        } catch(e){
            // same as above but when it's a version of I.E. that must have the global object for 'this', hopfully our context correct otherwise it will throw a global error
            return cachedSetTimeout.call(this, fun, 0);
        }
    }


}
function runClearTimeout(marker) {
    if (cachedClearTimeout === clearTimeout) {
        //normal enviroments in sane situations
        return clearTimeout(marker);
    }
    // if clearTimeout wasn't available but was latter defined
    if ((cachedClearTimeout === defaultClearTimeout || !cachedClearTimeout) && clearTimeout) {
        cachedClearTimeout = clearTimeout;
        return clearTimeout(marker);
    }
    try {
        // when when somebody has screwed with setTimeout but no I.E. maddness
        return cachedClearTimeout(marker);
    } catch (e){
        try {
            // When we are in I.E. but the script has been evaled so I.E. doesn't  trust the global object when called normally
            return cachedClearTimeout.call(null, marker);
        } catch (e){
            // same as above but when it's a version of I.E. that must have the global object for 'this', hopfully our context correct otherwise it will throw a global error.
            // Some versions of I.E. have different rules for clearTimeout vs setTimeout
            return cachedClearTimeout.call(this, marker);
        }
    }



}
var queue = [];
var draining = false;
var currentQueue;
var queueIndex = -1;

function cleanUpNextTick() {
    if (!draining || !currentQueue) {
        return;
    }
    draining = false;
    if (currentQueue.length) {
        queue = currentQueue.concat(queue);
    } else {
        queueIndex = -1;
    }
    if (queue.length) {
        drainQueue();
    }
}

function drainQueue() {
    if (draining) {
        return;
    }
    var timeout = runTimeout(cleanUpNextTick);
    draining = true;

    var len = queue.length;
    while(len) {
        currentQueue = queue;
        queue = [];
        while (++queueIndex < len) {
            if (currentQueue) {
                currentQueue[queueIndex].run();
            }
        }
        queueIndex = -1;
        len = queue.length;
    }
    currentQueue = null;
    draining = false;
    runClearTimeout(timeout);
}

process.nextTick = function (fun) {
    var args = new Array(arguments.length - 1);
    if (arguments.length > 1) {
        for (var i = 1; i < arguments.length; i++) {
            args[i - 1] = arguments[i];
        }
    }
    queue.push(new Item(fun, args));
    if (queue.length === 1 && !draining) {
        runTimeout(drainQueue);
    }
};

// v8 likes predictible objects
function Item(fun, array) {
    this.fun = fun;
    this.array = array;
}
Item.prototype.run = function () {
    this.fun.apply(null, this.array);
};
process.title = 'browser';
process.browser = true;
process.env = {};
process.argv = [];
process.version = ''; // empty string to avoid regexp issues
process.versions = {};

function noop() {}

process.on = noop;
process.addListener = noop;
process.once = noop;
process.off = noop;
process.removeListener = noop;
process.removeAllListeners = noop;
process.emit = noop;
process.prependListener = noop;
process.prependOnceListener = noop;

process.listeners = function (name) { return [] }

process.binding = function (name) {
    throw new Error('process.binding is not supported');
};

process.cwd = function () { return '/' };
process.chdir = function (dir) {
    throw new Error('process.chdir is not supported');
};
process.umask = function() { return 0; };


/***/ }),

/***/ "./node_modules/skyflow-core/index.js":
/*!********************************************!*\
  !*** ./node_modules/skyflow-core/index.js ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(process, global) {

/**
 * Gets values from skyflow configuration file.
 * @param {string} key Data key, like 'key' 'key.subKey'
 * @returns {*}
 */
function getConfig(key) {
    let c = Handle.CONF, keys = key.split('.'), l = keys.length;
    for (let i = 0; i < l; i++) {
        key = keys[i];
        if (!c.hasOwnProperty(key)) {
            return undefined;
        }
        c = c[key];
    }
    return c;
}

const Handle = {
    CONF: {},
    CONFIG_FILE_NAME: 'skyflow.config.js',
    File: __webpack_require__(/*! ./src/File */ "./node_modules/skyflow-core/src/File.js"),
    Validator: __webpack_require__(/*! ./src/Validator */ "./node_modules/skyflow-core/src/Validator.js"),
    Directory: __webpack_require__(/*! ./src/Directory */ "./node_modules/skyflow-core/src/Directory.js"),
    Helper: __webpack_require__(/*! ./src/Helper */ "./node_modules/skyflow-core/src/Helper.js"),
    Package: __webpack_require__(/*! ./package */ "./node_modules/skyflow-core/package.json"),
    getConfig: getConfig,
    get: (key) => {
        return getConfig('container.service.' + key);
    },
    invoke: (key, ...args) => {
        let c = getConfig('container.invokable.'+key);
        return Handle.Helper.isFunction(c) ? (c.apply(Handle, args)) : undefined;
    },
    isWindows: ()=>{
        return process.platform === 'win32';
    },
    isLinux: ()=>{
        return process.platform === 'linux';
    },
    isMac: ()=>{
        return process.platform === 'darwin';
    },
    isInux: ()=>{
        return Handle.isLinux() || Handle.isMac();
    },
};

global.Skyflow = Handle;
/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../process/browser.js */ "./node_modules/process/browser.js"), __webpack_require__(/*! ./../webpack/buildin/global.js */ "./node_modules/webpack/buildin/global.js")))

/***/ }),

/***/ "./node_modules/skyflow-core/package.json":
/*!************************************************!*\
  !*** ./node_modules/skyflow-core/package.json ***!
  \************************************************/
/*! exports provided: name, version, description, main, scripts, repository, keywords, author, license, bugs, homepage, default */
/***/ (function(module) {

module.exports = {"name":"skyflow-core","version":"1.0.3-beta.2","description":"Best friend of the developer","main":"index.js","scripts":{"test":"echo \"Error: no test specified\" && exit 1"},"repository":{"type":"git","url":"git+https://github.com/skyflow-io/npm-skyflow-core.git"},"keywords":["directory","file","validator","helper","project","invokable","service","container"],"author":"Franck DIOMANDE <fkdiomande@gmail.com>","license":"Apache-2.0","bugs":{"url":"https://github.com/skyflow-io/npm-skyflow-core/issues"},"homepage":"https://github.com/skyflow-io/npm-skyflow-core#readme"};

/***/ }),

/***/ "./node_modules/skyflow-core/src/Directory.js":
/*!****************************************************!*\
  !*** ./node_modules/skyflow-core/src/Directory.js ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


const fs = __webpack_require__(/*! fs */ "./node_modules/node-libs-browser/mock/empty.js"), path = __webpack_require__(/*! path */ "./node_modules/path-browserify/index.js"), Helper = __webpack_require__(/*! ./Helper */ "./node_modules/skyflow-core/src/Helper.js");

class Directory {

    /**
     * Synchronous creates new directory.
     * @param {string} directory
     * @returns {Directory}
     */
    create(directory){

        const dirs = directory.split(/[\\\/]/);

        directory = '';

        dirs.every((dir)=>{
            directory += dir + path.sep;
            if(!this.exists(directory)){
                fs.mkdirSync(directory);
            }
            return true
        });

        return this
    }

    /**
     * Synchronous removes new directory.
     * @param {string} directory
     * @returns {Directory}
     */
    delete(directory){

        if(!this.exists(directory)){
            return this
        }

        const files = fs.readdirSync(directory);

        files.every((dir)=>{
            dir = directory + path.sep + dir;

            if(this.exists(dir)){
                this.delete(dir)
            }else {
                fs.unlinkSync(dir)
            }

            return true

        });

        fs.rmdirSync(directory)

    }

    /**
     * Synchronous removes new directory. Alias of delete method.
     * @param {string} directory
     * @returns {Directory}
     */
    remove(directory){
        return this.delete(directory)
    }

    /**
     * Synchronous copies a directory.
     * @param {string} source
     * @param {string} destination
     * @returns {Directory}
     */
    copy(source, destination){

        this.create(destination);

        const files = fs.readdirSync(source);

        files.every((dir)=>{
            let dest = destination + path.sep + dir;
            dir = source + path.sep + dir;

            if(this.exists(dir)){
                this.copy(dir, dest)
            }else {
                fs.createReadStream(dir).pipe(fs.createWriteStream(dest))
            }

            return true

        });

        return this

    }

    /**
     * Synchronous renames a directory.
     * @param {string} oldDirectory
     * @param {string} newDirectory
     * @returns {Directory}
     */
    rename(oldDirectory, newDirectory){
        fs.renameSync(oldDirectory, newDirectory);
        return this
    }

    /**
     * Checks if directory exists.
     * @param {string} directory
     * @returns {Boolean}
     */
    exists(directory){
        try{
            return fs.statSync(directory).isDirectory()
        }catch (e){
            return false
        }

    }

    /**
     * Synchronous reads a directory.
     * @param {string} directory
     * @param {object} options
     * @returns {array}
     */
    read(directory, options = {directory: true, file: true, filter: /.*/}){

        if(!Helper.isObject(options)){options = {}}

        if(!Helper.isBoolean(options.directory)){options.directory = true}

        if(!Helper.isBoolean(options.file)){options.file = true}

        if(!Helper.isRegExp(options.filter)){options.filter = /.*/}

        let result = [];

        const files = fs.readdirSync(directory);

        files.every((dir)=>{

            if(!options.filter.test(dir)){
                return true
            }

            let d = directory + path.sep + dir;

            if(this.exists(d) && options.directory){
                result.push(dir)
            }

            if(!this.exists(d) && options.file){
                result.push(dir)
            }

            return true

        });

        return result
    }

}

module.exports = new Directory();

/***/ }),

/***/ "./node_modules/skyflow-core/src/File.js":
/*!***********************************************!*\
  !*** ./node_modules/skyflow-core/src/File.js ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


const fs = __webpack_require__(/*! fs */ "./node_modules/node-libs-browser/mock/empty.js"), resolve = __webpack_require__(/*! path */ "./node_modules/path-browserify/index.js").resolve, os = __webpack_require__(/*! os */ "./node_modules/os-browserify/browser.js");

class File {

    /**
     * Synchronous creates new file, replacing the file if it already exists.
     * @param {string|Buffer|URL|int} file Filename or file descriptor
     * @param {string} content
     * @returns {File}
     */
    create(file, content = ''){
        return this.write(file, content, {encoding : 'utf8', mode: '0o666', flag : 'w'});
    }

    /**
     * Synchronous creates new file with Json content, replacing the file if it already exists.
     * @param {string} file
     * @param {object} json
     * @returns {File}
     */
    createJson(file, json = {}){
        return this.write(file, JSON.stringify(json), {encoding : 'utf8', mode: '0o666', flag : 'w'});
    }

    /**
     * Synchronous writes data to a file, replacing the file if it already exists.
     * @param {string|Buffer|URL|int} file Filename or file descriptor
     * @param {string} content
     * @param {string|Object} options
     * @link https://nodejs.org/dist/latest-v8.x/docs/api/fs.html#fs_fs_writefilesync_file_data_options
     * @returns {File}
     */
    write(file, content = '', options = {encoding : 'utf8', mode: '0o666', flag : 'a'}){
        fs.writeFileSync(file, content, options);
        return this
    }

    /**
     * Synchronous writes data to a file and adds empty line at end of file, replacing the file if it already exists.
     * @param {string|Buffer|URL|int} file Filename or file descriptor
     * @param {string} content
     * @param {string|Object} options
     * @link https://nodejs.org/dist/latest-v8.x/docs/api/fs.html#fs_fs_writefilesync_file_data_options
     * @returns {File}
     */
    writeln(file, content = '', options){
        return this.write(file, content+os.EOL, options)
    }

    /**
     * Synchronous writes empty line to a file, replacing the file if it already exists.
     * @param {string|Buffer|URL|int} file Filename or file descriptor
     * @param {int} count Number of lines.
     * @returns {File}
     */
    newLine(file, count = 1){
        return this.write(file, os.EOL.repeat(count))
    }

    /**
     * Synchronous removes a file.
     * @param {string|Buffer|URL|int} file Filename or file descriptor
     * @returns {File}
     */
    delete(file){
        fs.unlinkSync(file);
        return this
    }

    /**
     * Synchronous removes a file. Alias of delete method.
     * @param {string|Buffer|URL|int} file Filename or file descriptor
     * @returns {File}
     */
    remove(file){
        return this.delete(file)
    }

    /**
     * Synchronous copies a file.
     * @param {string|Buffer|URL|int} source Filename or file descriptor
     * @param {string|Buffer|URL|int} destination Filename or file descriptor
     * @returns {File}
     */
    copy(source, destination){
        fs.createReadStream(source).pipe(fs.createWriteStream(resolve(destination)));
        return this
    }

    /**
     * Synchronous renames a file.
     * @param {string|Buffer|URL|int} oldFile Filename or file descriptor
     * @param {string|Buffer|URL|int} newFile Filename or file descriptor
     * @returns {File}
     */
    rename(oldFile, newFile){
        fs.renameSync(oldFile, newFile);
        return this
    }

    /**
     * Checks if a file exists.
     * @param {string|Buffer|URL|int} file Filename or file descriptor
     * @returns {Boolean}
     */
    exists(file){
        try{
            return fs.statSync(file).isFile()
        }catch (e){
            return false
        }
    }

    /**
     * Synchronous reads a file content.
     * @param {string|Buffer|URL|int} file Filename or file descriptor
     * @param {string|Object} options
     * @returns {string}
     */
    read(file, options = {encoding : 'utf8'}){
         return fs.readFileSync(file, options)
    }

    /**
     * Synchronous reads a file content as Json.
     * @param {string|Buffer|URL|int} file Filename or file descriptor
     * @param {string|Object} options
     * @returns {string}
     */
    readJson(file, options){
        const content = this.read(file, options);
        return JSON.parse(content)
    }

}

module.exports = new File();

/***/ }),

/***/ "./node_modules/skyflow-core/src/Helper.js":
/*!*************************************************!*\
  !*** ./node_modules/skyflow-core/src/Helper.js ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


class Helper {

    /**
     * Gets type of a object.
     * @param {*} object
     * @returns {string|undefined}
     */
    getType(object) {
        if (object === null) {return null}
        if (object === undefined) {return undefined}
        let t = object.constructor.name;
        if (/^html[a-z]*element$/i.test(t)) {
            return 'Element'
        }
        return t;
    }

    /**
     * Checks if an object is empty.
     * @param {*} o
     * @returns {boolean} Returns true for empty array, string, object, false, undefined, 0, null, NaN
     */
    isEmpty(o) {
        if (!o) {
            return true
        }
        for (let k in o) {
            if (o.hasOwnProperty(k)) {
                return false
            }
        }

        if (o === true || this.isNumber(o)) {
            return false
        }

        return true;
    }

    convertToArray(o) {

        if (this.isObject(o)) {
            let res = [];
            for (let k in o) {
                if (o.hasOwnProperty(k)) {
                    res.push(o[k]);
                }
            }
            return res;
        }

        return [].slice.call(o);

    }

    isString(o) {
        return this.getType(o) === "String"
    }

    isNumber(o) {
        return this.getType(o) === "Number"
    }

    isArray(o) {
        return this.getType(o) === "Array"
    }

    isFunction(o) {
        return this.getType(o) === "Function"
    }

    isObject(o) {
        return this.getType(o) === "Object"
    }

    isRegExp(o) {
        return this.getType(o) === "RegExp"
    }

    isBoolean(o) {
        return this.getType(o) === "Boolean"
    }

    isBool(o) {
        return this.isBoolean(o)
    }

    lowerFirst(text){
        return (text.slice(0, 1)).toLowerCase() + text.slice(1);
    }

    upperFirst(text){
        return (text.slice(0, 1)).toUpperCase() + text.slice(1);
    }

}

module.exports = new Helper();

/***/ }),

/***/ "./node_modules/skyflow-core/src/Validator.js":
/*!****************************************************!*\
  !*** ./node_modules/skyflow-core/src/Validator.js ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

class Validator {

    /**
     * Validator constructor
     * @param {RegExp} validator
     * @param {String} errorMessage
     */
    constructor(validator, errorMessage = ''){
        this.validator = validator;
        this.errorMessage = errorMessage;
    }

    /**
     * Gets validator
     * @returns {RegExp}
     */
    getValidator(){
        return this.validator
    }

    /**
     * Gets error message
     * @returns {String}
     */
    getErrorMessage(){
        return this.errorMessage
    }

    /**
     * Checks if text is valid
     * @param {String} text
     * @returns {boolean}
     */
    isValid(text){
        return this.validator.test(text)
    }

}


module.exports = Validator;

/***/ }),

/***/ "./node_modules/webpack/buildin/global.js":
/*!***********************************!*\
  !*** (webpack)/buildin/global.js ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

var g;

// This works in non-strict mode
g = (function() {
	return this;
})();

try {
	// This works if eval is allowed (see CSP)
	g = g || Function("return this")() || (1, eval)("this");
} catch (e) {
	// This works if the window reference is available
	if (typeof window === "object") g = window;
}

// g can still be undefined, but nothing to do about it...
// We return undefined, instead of nothing here, so it's
// easier to handle this case. if(!global) { ...}

module.exports = g;


/***/ }),

/***/ "./scss/app.scss":
/*!***********************!*\
  !*** ./scss/app.scss ***!
  \***********************/
/*! no static exports found */
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ "./skyflow.config.js":
/*!***************************!*\
  !*** ./skyflow.config.js ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


/***/ }),

/***/ "./webpack/webpack.bootstrap.js":
/*!**************************************!*\
  !*** ./webpack/webpack.bootstrap.js ***!
  \**************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


// Import skyflow core. Skyflow global object will be available.
__webpack_require__(/*! skyflow-core */ "./node_modules/skyflow-core/index.js"); // Import configuration from skyflow.config.js


Skyflow.CONF = __webpack_require__(/*! ../skyflow.config */ "./skyflow.config.js"); // Sass files

__webpack_require__(/*! ../scss/app.scss */ "./scss/app.scss"); // JS files


__webpack_require__(/*! ../js/url-form */ "./js/url-form.js");

/***/ })

/******/ });
//# sourceMappingURL=app.js.map