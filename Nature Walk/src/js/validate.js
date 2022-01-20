function validate(event) {
  // TODO - write custom validation logic to validate the longitude and latitude
  // values. The latitude value must be a number between -90 and 90; the
  // longitude value must be a number between -180 and 180. If either/both are
  // invalid, show the appropriate error message in the form, and stop the
  // form from being submitted. If both values are valid, allow the form to be
  // submitted.
  console.log(
    "TODO - validate the longitude, latitude values before submitting"
  );
  let FormValue = document.querySelector("#obs-form");
  let lat = FormValue.lat.value;
  let lng = FormValue.lng.value;
  let latErr = document.querySelector("#lat-error-msg");
  let lngErr = document.querySelector("#lng-error-msg");
  lngErr.hidden = true;
  latErr.hidden = true;
  let regex = /^-?[0-9]+\.?[0-9]+$/;
  console.log(typeof lat);
  if (lat < -90 || lat > 90 || !lat.match(regex)) {
    latErr.hidden = false;
    event.preventDefault();
  } else if (lng < -180 || lng > 180 || !lng.match(regex)) {
    lngErr.hidden = false;
    event.preventDefault();
  } else {
    FormValue.submit();
  }
}

// Wait for the window to load, then set up the submit event handler for the form.
window.onload = function () {
  const form = document.querySelector("form");
  form.onsubmit = validate;
};
