  $(document).ready(function(){
    var People = [
    {
    "department" : "Engineering",
    "gender" : "Female",
    "mentees" : "2",
    "office" : "SF",
    "years experience" : "4.5",
    "personal interests" : "soccer, reading",
    "mentoring strengths" : "career path from technical track to management, difficult conversations, taking risks, leadership",
    "management style" : "benevolent dictator?",
    "career challenges" : "going into mgmt, taking risks, bad managers",
    "professional interests" : "leadership, organizational health and effectiveness",
    "email address" : "boo@box.com",
    "name" : "Barbara"
    },
    {
    "department" : "Marketing",
    "gender" : "Male",
    "mentees" : "0",
    "office" : "HQ",
    "years experience" : "20",
    "personal interests" : "football",
    "mentoring strengths" : "influencing others, public speaking",
    "management style" : "n/a",
    "career challenges" : "leave of absence",
    "professional interests" : "leadership, organizational health and effectiveness",
    "email address" : "blah@box.com",
    "name" : "Bill"
    },
    {
    "department" : "People Ops",
    "gender" : "Female",
    "mentees" : "4",
    "office" : "HQ",
    "years experience" : "2",
    "personal interests" : "tai chi",
    "mentoring strengths" : "career growth, exploring new opportunities",
    "management style" : "n/a",
    "career challenges" : "transitioning between very different careers",
    "professional interests" : "understanding motivations, debugging people",
    "email address" : "baz@box.com",
    "name" : "Helen"
    },
    ];
    for (i = 0; i < People.length; i++) {
      var personHTML =
      '<div class="outer-person wow bounceInLeft">'+
        '<p class="gender">'+People[i]['gender']+'</p>'+
        '<p class="person-office">Office: '+People[i]['office']+'</p>'+
        '<p class="person-strengths">Mentoring Strengths:  '+People[i]['mentoring strengths']+'</p>'+
        '<p class="person-years">'+People[i]['years experience']+' years experience</p>'+
        '<p class="person-interests">Personal Interests: '+People[i]['personal interests']+'</p>'+
        '<p class="management-style">Management Style: '+People[i]['management style']+'</p>'+
        '<p class="career-challenges">Career Challenges: '+People[i]['career challenges']+'</p>'+
        '<p class="professional-interests">Professional Interests: '+People[i]['professional interests']+'</p>'+
        '<p class="department">Department: '+People[i]['department']+'</p>'+
        '<p class="email"><a class="email-link" href="mailto:'+People[i]['email address']+'" target="_top">Contact</a></p>'+
      '</div>'
      $('#mentors').append(personHTML);
    }
    $('#search-people').on("keyup", function(){
      var searchTerm = $(this).val().toLowerCase();
      if(searchTerm.length){
        $('.outer-person').each(function(){
          if($(this).text().toLowerCase().indexOf(searchTerm) > -1){
            $(this).fadeIn();
          }else{
            $(this).fadeOut();
          };
        });
      }else{
        $('.outer-person').show();
      }
    });
  });
