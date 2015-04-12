<script>

	// Full list of configuration options available at:
	// https://github.com/hakimel/reveal.js#configuration
	Reveal.initialize({
		controls: false,
		progress: true,
		history: true,
		center: true,

		transition: 'slide', // none/fade/slide/convex/concave/zoom

		// Optional reveal.js plugins
		dependencies: [
			{ src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },
			{ src: 'plugin/markdown/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
			{ src: 'plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
			{ src: 'plugin/highlight/highlight.js', async: true, condition: function() { return !!document.querySelector( 'pre code' ); }, callback: function() { hljs.initHighlightingOnLoad(); } },
			{ src: 'plugin/zoom-js/zoom.js', async: true },
			{ src: 'plugin/notes/notes.js', async: true }
		]
	});

	Reveal.addEventListener( 'fragmentshown', function( event ) {
    	var frag = event.fragment;
    	var script = frag.getElementsByTagName('script')[0];
		var toto = eval(script.innerHTML);
		toto.show();
	}, false );
	Reveal.addEventListener( 'fragmenthidden', function( event ) {
    	var frag = event.fragment;
    	var script = frag.getElementsByTagName('script')[0];
		var toto = eval(script.innerHTML);
		toto.hide();
	}, false );

</script>
