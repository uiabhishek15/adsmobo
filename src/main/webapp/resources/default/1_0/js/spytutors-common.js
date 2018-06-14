$(function() {
        // we get a normal Location object
        /*
         * Note, this is the only difference when using this library,
         * because the object window.location cannot be overriden,
         * so library the returns generated "location" object within
         * an object window.history, so get it out of "history.location".
         * For browsers supporting "history.pushState" get generated
         * object "location" with the usual "window.location".
         */
        var location = window.history.location || window.location;

        // looking for all the links and hang on the event, all references in this document
        $(document).on('click', 'a.ajax', function() {
          // keep the link in the browser history
          history.pushState(null, null, this.href);
          // here can cause data loading, etc.

          // do not give a default action
          return false;
        });
        
        // hang on popstate event triggered by pressing back/forward in browser
        $(window).on('popstate', function(e) {

          // here can cause data loading, etc.

          // just post          
          var hiddenURL = location.href;
          document.getElementById('hiddenNavigation').value = hiddenURL;
          hiddenNavigationCmd();
          //alert("We returned to the page with a link: " + location.href);
        });
      });	  
		    function handleComplete(val) {  
		        window.location.hash = val;
		    }  