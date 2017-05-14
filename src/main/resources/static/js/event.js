  $(document).ready(function() {
	  
	  
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	firstName: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Please supply your first name'
                    }
                }
            },
             lastName: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply your last name'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    emailAddress: {
                        message: 'Please supply a valid email address'
                    }
                }
            },
            password: {
            	validators: {
            		stringLength: {
                        min: 5,
                    },                    
                    notEmpty: {
                        message: 'The password is required and can\'t be empty'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: 'The password and its confirm are not the same'
                    }
                }
            },
            reTypePassword: {
                validators: {
                    notEmpty: {
                        message: 'The confirm password is required and can\'t be empty'
                    },
                    identical: {
                        field: 'password',
                        message: 'The password and its confirm are not the same'
                    }
                }
            },
            dateOfBirth: {
            	validators: {
            		 notEmpty: {
                         message: 'Please supply your email address'
                     },
                     date: {
                         format: 'MM/DD/YYYY',
                         message: 'The date of birth is not valid'
                     }
            	}
            },
            phone: {
                validators: {
                  phone: {
                        country: 'US',
                        message: 'Please supply a vaild phone number with area code'
                    }
                }
            },
            streetAddress: {
               validators: {
//                     stringLength: {
//                        min: 8,
//                    },
                    notEmpty: {
                        message: 'Please supply your street address'
                    }
                }
            },
            city: {
//                validators: {
//                     stringLength: {
//                        min: 4,
//                    },
//                    notEmpty: {
//                        message: 'Please supply your city'
//                    }
//                }
            },
            state: {
//                validators: {
//                    notEmpty: {
//                        message: 'Please select your state'
//                    }
//                }
            },
            zip: {
                validators: {
//                    notEmpty: {
//                        message: 'Please supply your zip code'
//                    },
                    zipCode: {
                        country: 'US',
                        message: 'Please supply a vaild zip code'
                    }
                }
            },
            comment: {
                validators: {
                      stringLength: {
                        min: 10,
                        max: 200,
                        message:'Please enter at least 10 characters and no more than 200'
                    },
                    notEmpty: {
                        message: 'Please supply a description of your project'
                    }
                    }
                }
            }
        }).find('#dobId')
        .datepicker({
            onSelect: function(date, inst) {
                /* Revalidate the field when choosing it from the datepicker */
                $('#contact_form').bootstrapValidator('revalidateField', 'dateOfBirth');
            }
        });
    
  	  
        $('#add-events-form').bootstrapValidator({
            // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	
//            	schoolName: {
//                    validators: {
//                            stringLength: {
//                            min: 2,
//                        },
//                            notEmpty: {
//                            message: 'Please supply school name'
//                        }
//                    }
//                },
//                schoolPhone: {
//                    validators: {
//                        notEmpty: {
//                            message: 'Please supply school phone number'
//                        },
//                        phone: {
//                            country: 'US',
//                            message: 'Please supply a vaild school phone number with area code'
//                        }
//                    }
//                },
//            	firstName: {
//                    validators: {
//                            stringLength: {
//                            min: 2,
//                        },
//                            notEmpty: {
//                            message: 'Please supply your first name'
//                        }
//                    }
//                },
//                 lastName: {
//                    validators: {
//                         stringLength: {
//                            min: 2,
//                        },
//                        notEmpty: {
//                            message: 'Please supply your last name'
//                        }
//                    }
//                },
//                email: {
//                    validators: {
//                        notEmpty: {
//                            message: 'Please supply your email address'
//                        },
//                        emailAddress: {
//                            message: 'Please supply a valid email address'
//                        }
//                    }
//                },
//                password: {
//                	validators: {
//                		stringLength: {
//                            min: 5,
//                        },                    
//                        notEmpty: {
//                            message: 'The password is required and can\'t be empty'
//                        },
//                        identical: {
//                            field: 'confirmPassword',
//                            message: 'The password and its confirm are not the same'
//                        }
//                    }
//                },
//                reTypePassword: {
//                    validators: {
//                        notEmpty: {
//                            message: 'The confirm password is required and can\'t be empty'
//                        },
//                        identical: {
//                            field: 'password',
//                            message: 'The password and its confirm are not the same'
//                        }
//                    }
//                },
//                phone: {
//                    validators: {
//                      phone: {
//                            country: 'US',
//                            message: 'Please supply a vaild phone number with area code'
//                        }
//                    }
//                },
//                dateOfBirth: {
//                	validators: {
//                		 notEmpty: {
//                             message: 'Please supply your email address'
//                         },
//                         date: {
//                             format: 'MM/DD/YYYY',
//                             message: 'The date of birth is not valid'
//                         }
//                	}
//                },
//                streetAddress: {
//                   validators: {
//                         stringLength: {
//                            min: 8,
//                        },
//                        notEmpty: {
//                            message: 'Please supply street address'
//                        }
//                    }
//                },
//                city: {
//                    validators: {
//                         stringLength: {
//                            min: 4,
//                        },
//                        notEmpty: {
//                            message: 'Please supply city'
//                        }
//                    }
//                },
//                state: {
//                    validators: {
//                        notEmpty: {
//                            message: 'Please select state'
//                        }
//                    }
//                },
//                zip: {
//                    validators: {
//                       notEmpty: {
//                            message: 'Please supply zip code'
//                        },
//                        zipCode: {
//                            country: 'US',
//                            message: 'Please supply a vaild zip code'
//                        }
//                    }
//                }
            }
      })
       .find('#dateTimePickerId')
       .datetimepicker({
           onSelect: function(date, inst) {
               /* Revalidate the field when choosing it from the datepicker */
               $('#add-events-form').bootstrapValidator('revalidateField', 'dateOfBirth');
           }
       });
        
      
        
        
        $('#school_rep_form').bootstrapValidator({
            // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	
            	schoolName: {
                    validators: {
                            stringLength: {
                            min: 2,
                        },
                            notEmpty: {
                            message: 'Please supply school name'
                        }
                    }
                },
                schoolPhone: {
                    validators: {
                        notEmpty: {
                            message: 'Please supply school phone number'
                        },
                        phone: {
                            country: 'US',
                            message: 'Please supply a vaild school phone number with area code'
                        }
                    }
                },
            	firstName: {
                    validators: {
                            stringLength: {
                            min: 2,
                        },
                            notEmpty: {
                            message: 'Please supply your first name'
                        }
                    }
                },
                 lastName: {
                    validators: {
                         stringLength: {
                            min: 2,
                        },
                        notEmpty: {
                            message: 'Please supply your last name'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'Please supply your email address'
                        },
                        emailAddress: {
                            message: 'Please supply a valid email address'
                        }
                    }
                },
                password: {
                	validators: {
                		stringLength: {
                            min: 5,
                        },                    
                        notEmpty: {
                            message: 'The password is required and can\'t be empty'
                        },
                        identical: {
                            field: 'confirmPassword',
                            message: 'The password and its confirm are not the same'
                        }
                    }
                },
                reTypePassword: {
                    validators: {
                        notEmpty: {
                            message: 'The confirm password is required and can\'t be empty'
                        },
                        identical: {
                            field: 'password',
                            message: 'The password and its confirm are not the same'
                        }
                    }
                },
                phone: {
                    validators: {
                      phone: {
                            country: 'US',
                            message: 'Please supply a vaild phone number with area code'
                        }
                    }
                },
                dateOfBirth: {
                	validators: {
                		 notEmpty: {
                             message: 'Please supply your email address'
                         },
                         date: {
                             format: 'MM/DD/YYYY',
                             message: 'The date of birth is not valid'
                         }
                	}
                },
                streetAddress: {
                   validators: {
                         stringLength: {
                            min: 8,
                        },
                        notEmpty: {
                            message: 'Please supply street address'
                        }
                    }
                },
                city: {
                    validators: {
                         stringLength: {
                            min: 4,
                        },
                        notEmpty: {
                            message: 'Please supply city'
                        }
                    }
                },
                state: {
                    validators: {
                        notEmpty: {
                            message: 'Please select state'
                        }
                    }
                },
                zip: {
                    validators: {
                       notEmpty: {
                            message: 'Please supply zip code'
                        },
                        zipCode: {
                            country: 'US',
                            message: 'Please supply a vaild zip code'
                        }
                    }
                }
            }
       }).find('#dobId')
       .datepicker({
           onSelect: function(date, inst) {
               /* Revalidate the field when choosing it from the datepicker */
               $('#school_rep_form').bootstrapValidator('revalidateField', 'dateOfBirth');
           }
       });
            
});

