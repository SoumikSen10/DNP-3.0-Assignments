//Your jQuery code here executes when document is ready
// Write the jQuery codes inside it

$(document).ready(function () {
  //console.log(jQuery);  Output: ƒ (e,t){return new ce.fn.init(e,t)}
  /* 
     jQuery Syntax :-
     $('selector').action() 
  */
  //$("p").click(); //click on p
  /* $("p").click(function () {
    console.log("You clicked on p"); // do this when we click on p
    //$("p").hide(); //to hide it
  }); */
  /* $("p").dblclick(function () {
    console.log("You double clicked on p!!".this);
  }); */
  /* $("p").on({
    click: function () {
      console.log("Thanks for clicking");
      alert("You clicked");
    },
    mouseleave: function () {
      console.log("mouse left");
    },
  });

  $("#test").hide(2000, function () {
    console.log("Successfully hidden!");
  });

  $("#test").show(1000, function () {
    console.log("Successfully shown!");
  }); */

  /* $("#btn").click(function () {
    $("#test").fadeIn(2000);
    console.log("Faded in!");
  }); */

  /* $("btn").click(function () {
    $("#test").fadeToggle(2000);
    console.log("Fade toggle!");
  });*/

  $("btn").click(function () {
    $("#test").fadeOut(5000);
    console.log("Faded out!");
  });

  /* $("btn").click(function () {
    $("#test").fadeTo(2000);
    console.log("Faded to!");
  }); */
});
