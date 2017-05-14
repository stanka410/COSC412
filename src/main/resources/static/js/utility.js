var stripe = Stripe('pk_test_CqQsrTcvsdkOKFw0H09XuRsC');
var elements = stripe.elements();

var card = elements.create('card', {
  hidePostalCode: true,
  style: {
    base: {
      iconColor: '#F99A52',
      color: '#32315E',
      lineHeight: '20px',
      fontWeight: 400,
      fontFamily: '"Helvetica Neue", "Helvetica", sans-serif',
      fontSize: '15px',

      '::placeholder': {
        color: '#CFD7DF',
      }
    },
  }
});
card.mount('#cardNumberId');

function setOutcome(result) {
  var successElement = document.querySelector('.success');
  var errorElement = document.querySelector('.error');
  successElement.classList.remove('visible');
  errorElement.classList.remove('visible');

  if (result.token) {
    // Use the token to create a charge or a customer
    // https://stripe.com/docs/charges
    successElement.querySelector('.token').textContent = result.token.id;
    successElement.classList.add('visible');
  } else if (result.error) {
    errorElement.textContent = result.error.message;
    errorElement.classList.add('visible');
  }
}

card.on('change', function(event) {
  setOutcome(event);
});


function stripeTokenHandler(token) {
	  // Insert the token ID into the form so it gets submitted to the server
	  var form = document.getElementById('paymentForm');
	  var hiddenInput = document.createElement('input');
	  hiddenInput.setAttribute('type', 'hidden');
	  hiddenInput.setAttribute('name', 'stripeToken');
	  hiddenInput.setAttribute('value', token.id);
	  form.appendChild(hiddenInput);

	  // Submit the form
	  form.submit();
	}

//Create a token or display an error when the form is submitted.
var form = document.getElementById('paymentForm');
form.addEventListener('submit', function(event) {
  event.preventDefault();

  stripe.createToken(card).then(function(result) {
    if (result.error) {
      // Inform the user if there was an error
      var errorElement = document.getElementById('card-errors');
      errorElement.textContent = result.error.message;
    } else {
      // Send the token to your server
      stripeTokenHandler(result.token);
    }
  });
});




//document.querySelector('form').addEventListener('submit', function(e) {
//  e.preventDefault();
//  var form = document.querySelector('form');
//  var extraDetails = {
//    name: form.querySelector('input[name=cardholder-name]').value,
//    address_zip: form.querySelector('input[name=address-zip]').value
//  };
//  stripe.createToken(card, extraDetails).then(setOutcome);
//});