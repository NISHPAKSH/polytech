package com.ttc.polytechnicshiksha;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MotionEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.security.acl.Group;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TPO_college extends AppCompatActivity {

    Button Button_TPO;
    EditText Company_Name, Company_Address,web_url,comp_profile,tenth_percent,twelth_percent,diploma_percent;
    EditText back_paper,designation,pay,total_post,other_facility,campus_venue,campus_date,campus_time;
    EditText contact_info,reg_form,other_info;
    CheckBox gpcajmer,gpcalwar,gpcbagidora,gpcbanswara,gpcbaran,gpcbarmer,gpcbharatpur,gpcbhilwara,gpcbikaner;
    CheckBox gpcbundi,gpcchittorgarh,gpcchuru,gpcdausa,gpcdholpur,gpcdungarpur,gpchanumangarh,gpcjaipur;
    CheckBox gpcjaisalmer,gpcjalore,gpcjhalawar,gpcjhunjhunu,gpcjodhpur,gpckaroli,gpckelwara,gpckota;
    CheckBox gpcnagore,gpcneemrana,gpcpali,gpcpratapgarh,gpcrajsamand,gpcsawaimadhopur,gpcsikar,gpcsirohi;
    CheckBox gpcsriganganagar,gpctonk,gpcudaipur,gwpcajmer,gwpcbharatpur,gwpcbikaner,gwpcjaipur;
    CheckBox gwpcjodhpur,gwpckota,gwpcsanganer,gwpcudaipur,allgovt,allpvt;
    CheckBox cbar,cbch,cbce,cbcc,cbcs,cbee,cbel,cbef,cber,cbit,cbie,cbme,cbma,cbmp,cbmr,cbpe,cbpt,cbprt;
    CheckBox cbhmct,cbpsrt,cbmechtr,cbcfis,cbcee,cbbc,cbca,cbcddm,cbid,cbmom,cbtd,cbfd,cbftd,cbvg;
    CheckBox rp_cbppt,rp_cbaptitude,rp_cbotest,rp_cbhrinterview,rp_cbtechtest,rp_cbgd,rp_cbtechinterview;
    CheckBox phdoc_cb_tenth, phdoc_cb_twelth,phdoc_cb_tenthc, phdoc_cb_twelthc, phdoc_cb_diploma, phdoc_cb_diplomac, phdoc_cb_pancard, phdoc_cb_aadhar, phdoc_cb_bankbook;
    CheckBox original_cb_tenth, original_cb_twelth,original_cb_diploma, original_cb_tenthc, original_cb_twelthc,original_cb_diplomac, original_cb_pancard, original_cb_aadhar;
    CheckBox cb_passyear1,cb_passyear2,cb_passyear3,cb_passyear4,cb_passyear5;
    RadioGroup rggender,rgresume, rgbackpaper;
    RadioGroup rgresfaci,rgtransfaci,rgfoodfaci;
    RadioButton rbgender,rbresfaci,rbtransfaci,rbfodfaci,rbresume, rbbackpaper;
    TextView College_name_view;
    TextView tv_sp1;
    TextView tv_sp2;
    TextView tv_sp3;
    TextView tv_back;
    String College_name;
    String COMPANY_NAME,COMPANY_ADDRESS,Eligible_colleges;
    String WEB_URL,COMP_PROFILE,TENTH_PERCENT,TWELTH_PERCENT,DIPLOMA_PERCENT,BACK_PAPER, BACK_PAPER_IF;
    String DESIGNATION,PAY,TOTAL_POST,OTHER_FACILITY,CAMPUS_VENUE,CAMPUS_DATE,CAMPUS_TIME,OTHER_INFO;
    String Eligible_branches = " ";
    String Recruitment_process = " ";
    String photocopy_doc = " ";
    String original_doc = " ";
    String gender = " ",resi_faci = " ",trans_faci = " ",food_faci = " ",resume_cv = " ";
    String item_passport_photo ;
    String passport_photo = " ", CONTACT_INFO = "", REG_FORM = "";

    private Calendar myCalendar = Calendar.getInstance();
    private int day, month, year;
    private int hour,minute;
    String hour_m,minute_m;
    private boolean mode;
    String AM__PM;
    String item1 = null;
    String item2 = null;
    String item3 = null;
    String pass_year = " ";
    List<String> list = new ArrayList<>();
    List<String> secondlist = new ArrayList<>();
    List<String> thirdlist = new ArrayList<>();


    ArrayAdapter<CharSequence> firstadap_spin ;
    ArrayAdapter<String> secondadap_spin ;
    ArrayAdapter<String> thirdadap_spin ;
    ArrayAdapter<CharSequence> photo_adap_spin ;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_college);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Placement Form");

        Spinner spinner_photo = (Spinner) findViewById(R.id.sp_photo_req);


        tv_back = (TextView) findViewById(R.id.tv_yes_backpaper);

        College_name_view = (TextView)findViewById(R.id.TPO_College_Name);
        Bundle bundle = getIntent().getExtras();
        College_name = bundle.getString("College_Name");
        College_name_view.setText(College_name);

        Button_TPO = (Button) findViewById(R.id.button_preview);
        Company_Name = (EditText) findViewById(R.id.ed_comp_name);
        Company_Address = (EditText) findViewById(R.id.et_comp_address);
        web_url = (EditText) findViewById(R.id.et_web_url);
        comp_profile = (EditText) findViewById(R.id.et_company_profile);
        tenth_percent = (EditText) findViewById(R.id.et_tenth);
        twelth_percent = (EditText) findViewById(R.id.et_twelth);
        diploma_percent = (EditText) findViewById(R.id.et_diploma);
        back_paper = (EditText) findViewById(R.id.et_bakpaper);
        designation = (EditText) findViewById(R.id.ed_designation);
        pay = (EditText) findViewById(R.id.ed_pay);
        total_post = (EditText) findViewById(R.id.ed_total_post);
        other_facility = (EditText) findViewById(R.id.ed_other_facility);
        campus_venue = (EditText) findViewById(R.id.ed_c_venue);
        campus_date = (EditText) findViewById(R.id.ed_date);
        campus_time = (EditText) findViewById(R.id.ed_c_time);
        contact_info = (EditText) findViewById(R.id.ed_contact_info);
        reg_form  = (EditText) findViewById(R.id.et_registration_form);
        other_info  = (EditText) findViewById(R.id.ed_other_info);

        back_paper.setVisibility(View.GONE);
        tv_back.setVisibility(View.GONE);
        allgovt=  (CheckBox) findViewById(R.id.cb_allgovt);
        allpvt=  (CheckBox) findViewById(R.id.cb_allpvt);
        gpcajmer=  (CheckBox) findViewById(R.id.cb_gpcajmer);
        gpcalwar=  (CheckBox) findViewById(R.id.cb_gpcalwar);
        gpcbagidora=  (CheckBox) findViewById(R.id.cb_gpcbagidora);
        gpcbanswara=  (CheckBox) findViewById(R.id.cb_gpcbanswara);
        gpcbaran=  (CheckBox) findViewById(R.id.cb_gpcbaran);
        gpcbarmer=  (CheckBox) findViewById(R.id.cb_gpcbarmer);
        gpcbharatpur=  (CheckBox) findViewById(R.id.cb_gpcbharatpur);
        gpcbhilwara=  (CheckBox) findViewById(R.id.cb_gpcbhilwara);
        gpcbikaner=  (CheckBox) findViewById(R.id.cb_gpcbikaner);
        gpcbundi=  (CheckBox) findViewById(R.id.cb_gpcbundi);
        gpcchittorgarh=  (CheckBox) findViewById(R.id.cb_gpcchittorgarh);
        gpcchuru=  (CheckBox) findViewById(R.id.cb_gpcchuru);
        gpcdausa=  (CheckBox) findViewById(R.id.cb_gpcdausa);
        gpcdholpur=  (CheckBox) findViewById(R.id.cb_gpcdholpur);
        gpcdungarpur=  (CheckBox) findViewById(R.id.cb_gpcdungarpur);
        gpchanumangarh=  (CheckBox) findViewById(R.id.cb_gpchanumangarh);
        gpcjaipur=  (CheckBox) findViewById(R.id.cb_gpcjaipur);
        gpcjaisalmer=  (CheckBox) findViewById(R.id.cb_gpcjaisalmer);
        gpcjalore=  (CheckBox) findViewById(R.id.cb_gpcjalore);
        gpcjhalawar=  (CheckBox) findViewById(R.id.cb_gpcjhalawar);
        gpcjhunjhunu=  (CheckBox) findViewById(R.id.cb_gpcjhunjhunu);
        gpcjodhpur=  (CheckBox) findViewById(R.id.cb_gpcjodhpur);
        gpckaroli=  (CheckBox) findViewById(R.id.cb_gpckaroli);
        gpckelwara=  (CheckBox) findViewById(R.id.cb_gpckelwara);
        gpckota=  (CheckBox) findViewById(R.id.cb_gpckota);
        gpcnagore=  (CheckBox) findViewById(R.id.cb_gpcnagore);
        gpcneemrana=  (CheckBox) findViewById(R.id.cb_gpcneemrana);
        gpcpali=  (CheckBox) findViewById(R.id.cb_gpcpali);
        gpcpratapgarh=  (CheckBox) findViewById(R.id.cb_gpcpratapgarh);
        gpcrajsamand=  (CheckBox) findViewById(R.id.cb_gpcrajsamand);
        gpcsawaimadhopur=  (CheckBox) findViewById(R.id.cb_gpcsawaimadhopur);
        gpcsikar=  (CheckBox) findViewById(R.id.cb_gpcsikar);
        gpcsirohi=  (CheckBox) findViewById(R.id.cb_gpcsirohi);
        gpcsriganganagar=  (CheckBox) findViewById(R.id.cb_gpcsriganganagar);
        gpctonk=  (CheckBox) findViewById(R.id.cb_gpctonk);
        gpcudaipur=  (CheckBox) findViewById(R.id.cb_gpcudaipur);
        gwpcajmer=  (CheckBox) findViewById(R.id.cb_gwpcajmer);
        gwpcbharatpur=  (CheckBox) findViewById(R.id.cb_gwpcbharatpur);
        gwpcbikaner=  (CheckBox) findViewById(R.id.cb_gwpcbikaner);
        gwpcjaipur=  (CheckBox) findViewById(R.id.cb_gwpcjaipur);
        gwpcjodhpur=  (CheckBox) findViewById(R.id.cb_gwpcjodhpur);
        gwpckota=  (CheckBox) findViewById(R.id.cb_gwpckota);
        gwpcsanganer=  (CheckBox) findViewById(R.id.cb_gwpcsanganer);
        gwpcudaipur=  (CheckBox) findViewById(R.id.cb_gwpcudaipur);


        cbar = (CheckBox) findViewById(R.id.cb_are);
        cbch = (CheckBox) findViewById(R.id.cb_che);
        cbce = (CheckBox) findViewById(R.id.cb_cee);
        cbcc = (CheckBox) findViewById(R.id.cb_cce);
        cbcs = (CheckBox) findViewById(R.id.cb_cse);
        cbee = (CheckBox) findViewById(R.id.cb_ee);
        cbel = (CheckBox) findViewById(R.id.cb_ele);
        cbef = (CheckBox) findViewById(R.id.cb_efe);
        cber = (CheckBox) findViewById(R.id.cb_elre);
        cbit = (CheckBox) findViewById(R.id.cb_ite);
        cbie = (CheckBox) findViewById(R.id.cb_iee);
        cbme = (CheckBox) findViewById(R.id.cb_me);
        cbma = (CheckBox) findViewById(R.id.cb_mae);
        cbmp = (CheckBox) findViewById(R.id.cb_mpe);
        cbmr = (CheckBox) findViewById(R.id.cb_mre);
        cbpe = (CheckBox) findViewById(R.id.cb_pe);
        cbpt = (CheckBox) findViewById(R.id.cb_plte);
        cbprt = (CheckBox) findViewById(R.id.cb_prte);
        cbhmct = (CheckBox) findViewById(R.id.cb_hmcte);
        cbpsrt = (CheckBox) findViewById(R.id.cb_psrte);
        cbmechtr = (CheckBox) findViewById(R.id.cb_mte);
        cbcfis = (CheckBox) findViewById(R.id.cb_cfise);
        cbcee = (CheckBox) findViewById(R.id.cb_cene);
        cbbc = (CheckBox) findViewById(R.id.cb_bcne);
        cbca = (CheckBox) findViewById(R.id.cb_cane);
        cbcddm = (CheckBox) findViewById(R.id.cb_cddmne);
        cbid = (CheckBox) findViewById(R.id.cb_idne);
        cbmom = (CheckBox) findViewById(R.id.cb_momne);
        cbtd = (CheckBox) findViewById(R.id.cb_tdne);
        cbfd = (CheckBox) findViewById(R.id.cb_fdne);
        cbftd = (CheckBox) findViewById(R.id.cb_ftdne);
        cbvg = (CheckBox) findViewById(R.id.cb_vgne);

        cb_passyear1 = (CheckBox) findViewById(R.id.cb_passyear1);
        cb_passyear2 = (CheckBox) findViewById(R.id.cb_passyear2);
        cb_passyear3 = (CheckBox) findViewById(R.id.cb_passyear3);
        cb_passyear4 = (CheckBox) findViewById(R.id.cb_passyear4);
        cb_passyear5 = (CheckBox) findViewById(R.id.cb_passyear5);

        rp_cbppt = (CheckBox) findViewById(R.id.cb_ppt);
        rp_cbaptitude = (CheckBox) findViewById(R.id.cb_aptitude);
        rp_cbotest = (CheckBox) findViewById(R.id.cb_online_test);
        rp_cbhrinterview = (CheckBox) findViewById(R.id.cb_hr_interview);
        rp_cbtechtest = (CheckBox) findViewById(R.id.cb_tech_written);
        rp_cbgd = (CheckBox) findViewById(R.id.cb_gd);
        rp_cbtechinterview = (CheckBox) findViewById(R.id.cb_tech_interview);

        phdoc_cb_tenth = (CheckBox) findViewById(R.id.cb_tenth);
        phdoc_cb_twelth = (CheckBox) findViewById(R.id.cb_twelth);
        phdoc_cb_diploma = (CheckBox) findViewById(R.id.cb_diploma);
        phdoc_cb_tenthc = (CheckBox) findViewById(R.id.cb_tenth_c);
        phdoc_cb_twelthc = (CheckBox) findViewById(R.id.cb_twelth_c);
        phdoc_cb_diplomac = (CheckBox) findViewById(R.id.cb_diploma_c);
        phdoc_cb_pancard = (CheckBox) findViewById(R.id.cb_pan);
        phdoc_cb_aadhar = (CheckBox) findViewById(R.id.cb_aadhar);
        phdoc_cb_bankbook = (CheckBox) findViewById(R.id.cb_bank_pass_book);

        original_cb_tenth = (CheckBox) findViewById(R.id.cb_tenth_ori);
        original_cb_twelth = (CheckBox) findViewById(R.id.cb_twelth_ori);
        original_cb_diploma = (CheckBox) findViewById(R.id.cb_diploma_ori);
        original_cb_tenthc = (CheckBox) findViewById(R.id.cb_tenthc_ori);
        original_cb_twelthc = (CheckBox) findViewById(R.id.cb_twelthc_ori);
        original_cb_diplomac = (CheckBox) findViewById(R.id.cb_diplomac_ori);
        original_cb_pancard = (CheckBox) findViewById(R.id.cb_pan_ori);
        original_cb_aadhar = (CheckBox) findViewById(R.id.cb_aadhar_ori);

        rggender = (RadioGroup) findViewById(R.id.rg_gender);
        rgresfaci = (RadioGroup) findViewById(R.id.rg_resid_faci);
        rgtransfaci = (RadioGroup) findViewById(R.id.rg_trans_faci);
        rgfoodfaci = (RadioGroup) findViewById(R.id.rg_food_faci);
        rgresume = (RadioGroup) findViewById(R.id.rg_resume_req);
        rgbackpaper = (RadioGroup) findViewById(R.id.rg_backpaper);


        photo_adap_spin = ArrayAdapter.createFromResource(this,R.array.passport_photo, R.layout.simple_spinner_item11);


        spinner_photo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item_passport_photo = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        photo_adap_spin.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner_photo.setAdapter(photo_adap_spin);

        day=myCalendar.get(Calendar.DAY_OF_MONTH);
        year=myCalendar.get(Calendar.YEAR);
        month=myCalendar.get(Calendar.MONTH);

        hour=myCalendar.get(Calendar.HOUR_OF_DAY);
        minute=myCalendar.get(Calendar.MINUTE);

        WEB_URL = web_url.getText().toString();
        web_url.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(web_url.getText().toString().equals("https://www.") || web_url.getText().toString().isEmpty()) {
                    web_url.onTouchEvent(event);
                    web_url.setText("https://www.");
                    web_url.setSelection(web_url.getText().length());
                }
                else if(!web_url.getText().toString().equals("https://www."))
                {
                    web_url.onTouchEvent(event);
                    web_url.setText(web_url.getText().toString());
                    web_url.setSelection(web_url.getText().length());
                }
                return false;
            }
        });


        rgbackpaper.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int back_id = rgbackpaper.getCheckedRadioButtonId();
                if(back_id != -1)
                {
                    rbbackpaper = (RadioButton) findViewById(back_id);
                    BACK_PAPER_IF = rbbackpaper.getText().toString();
                }

                if(BACK_PAPER_IF != null) {
                    if (BACK_PAPER_IF.equals("YES")) {
                        back_paper.setText("");
                        back_paper.setVisibility(View.VISIBLE);
                        tv_back.setVisibility(View.VISIBLE);
                    } else if (BACK_PAPER_IF.equals("NO")) {
                        back_paper.setText("Not Allowed");
                        back_paper.setVisibility(View.GONE);
                        tv_back.setVisibility(View.GONE);
                    }
                }
            }
        });

        campus_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialog();
            }
        });

        campus_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeDialog();
            }
        });

        Button_TPO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                COMPANY_NAME = Company_Name.getText().toString();
                COMPANY_ADDRESS = Company_Address.getText().toString();
                WEB_URL = web_url.getText().toString();
                COMP_PROFILE = comp_profile.getText().toString();
                TENTH_PERCENT = tenth_percent.getText().toString();
                TWELTH_PERCENT = twelth_percent.getText().toString();
                DIPLOMA_PERCENT = diploma_percent.getText().toString();
                BACK_PAPER = back_paper.getText().toString();
                DESIGNATION = designation.getText().toString();
                PAY = pay.getText().toString();
                TOTAL_POST = total_post.getText().toString();
                OTHER_FACILITY = other_facility.getText().toString();
                CAMPUS_VENUE = campus_venue.getText().toString();
                CAMPUS_DATE = campus_date.getText().toString();
                CAMPUS_TIME = campus_time.getText().toString();
                OTHER_INFO = other_info.getText().toString();
                REG_FORM = reg_form.getText().toString();
                CONTACT_INFO = contact_info.getText().toString();

                Eligible_branches = " ";
                Eligible_colleges = " ";

                if(!item_passport_photo.equals(null) && !item_passport_photo.equals("Select number of passport photos required..."))
                {

                    passport_photo = item_passport_photo;
                }
                else
                {
                    passport_photo = "";
                }

                {
                    int i = 0;
                    if (allgovt.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(allgovt.getText().toString());
                        i++;
                    }
                    if (allpvt.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(allpvt.getText().toString());
                        i++;
                    }
                    if (gpcajmer.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcajmer.getText().toString());
                        i++;
                    }
                    if (gpcalwar.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcalwar.getText().toString());
                        i++;
                    }
                    if (gpcbagidora.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcbagidora.getText().toString());
                        i++;
                    }
                    if (gpcbanswara.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcbanswara.getText().toString());
                        i++;
                    }
                    if (gpcbaran.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcbaran.getText().toString());
                        i++;
                    }
                    if (gpcbarmer.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcbarmer.getText().toString());
                        i++;
                    }
                    if (gpcbharatpur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcbharatpur.getText().toString());
                        i++;
                    }
                    if (gpcbhilwara.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcbhilwara.getText().toString());
                        i++;
                    }
                    if (gpcbikaner.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcbikaner.getText().toString());
                        i++;
                    }
                    if (gpcbundi.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcbundi.getText().toString());
                        i++;
                    }
                    if (gpcchittorgarh.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcchittorgarh.getText().toString());
                        i++;
                    }
                    if (gpcchuru.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcchuru.getText().toString());
                        i++;
                    }
                    if (gpcdausa.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcdausa.getText().toString());
                        i++;
                    }
                    if (gpcdholpur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcdholpur.getText().toString());
                        i++;
                    }
                    if (gpcdungarpur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcdungarpur.getText().toString());
                        i++;
                    }
                    if (gpchanumangarh.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpchanumangarh.getText().toString());
                        i++;
                    }
                    if (gpcjaipur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcjaipur.getText().toString());
                        i++;
                    }
                    if (gpcjaisalmer.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcjaisalmer.getText().toString());
                        i++;
                    }
                    if (gpcjalore.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcjalore.getText().toString());
                        i++;
                    }
                    if (gpcjhalawar.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcjhalawar.getText().toString());
                        i++;
                    }
                    if (gpcjhunjhunu.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcjhunjhunu.getText().toString());
                        i++;
                    }
                    if (gpcjodhpur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcjodhpur.getText().toString());
                        i++;
                    }
                    if (gpckaroli.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpckaroli.getText().toString());
                        i++;
                    }
                    if (gpckelwara.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpckelwara.getText().toString());
                        i++;
                    }
                    if (gpckota.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpckota.getText().toString());
                        i++;
                    }
                    if (gpcnagore.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcnagore.getText().toString());
                        i++;
                    }
                    if (gpcneemrana.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcneemrana.getText().toString());
                        i++;
                    }
                    if (gpcpali.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcpali.getText().toString());
                        i++;
                    }
                    if (gpcpratapgarh.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcpratapgarh.getText().toString());
                        i++;
                    }
                    if (gpcrajsamand.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcrajsamand.getText().toString());
                        i++;
                    }
                    if (gpcsawaimadhopur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcsawaimadhopur.getText().toString());
                        i++;
                    }
                    if (gpcsikar.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcsikar.getText().toString());
                        i++;
                    }
                    if (gpcsirohi.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcsirohi.getText().toString());
                        i++;
                    }
                    if (gpcsriganganagar.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcsriganganagar.getText().toString());
                        i++;
                    }
                    if (gpctonk.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpctonk.getText().toString());
                        i++;
                    }
                    if (gpcudaipur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gpcudaipur.getText().toString());
                        i++;
                    }
                    if (gwpcajmer.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gwpcajmer.getText().toString());
                        i++;
                    }
                    if (gwpcbharatpur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gwpcbharatpur.getText().toString());
                        i++;
                    }
                    if (gwpcbikaner.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gwpcbikaner.getText().toString());
                        i++;
                    }
                    if (gwpcjaipur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gwpcjaipur.getText().toString());
                        i++;
                    }
                    if (gwpcjodhpur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gwpcjodhpur.getText().toString());
                        i++;
                    }
                    if (gwpckota.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gwpckota.getText().toString());
                        i++;
                    }
                    if (gwpcsanganer.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gwpcsanganer.getText().toString());
                        i++;
                    }
                    if (gwpcudaipur.isChecked()) {
                        if (i != 0) {
                            Eligible_colleges = Eligible_colleges.concat(", ");
                        }
                        Eligible_colleges = Eligible_colleges.concat(gwpcudaipur.getText().toString());
                        i++;
                    }

                }

                {
                    int i = 0;
                    if (cbar.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbar.getText().toString());
                        i++;
                    }
                    if (cbch.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbch.getText().toString());
                        i++;
                    }
                    if (cbce.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbce.getText().toString());
                        i++;
                    }
                    if (cbcc.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbcc.getText().toString());
                        i++;
                    }
                    if (cbcs.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbcs.getText().toString());
                        i++;
                    }
                    if (cbee.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbee.getText().toString());
                        i++;
                    }
                    if (cbel.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbel.getText().toString());
                        i++;
                    }
                    if (cbef.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbef.getText().toString());
                        i++;
                    }
                    if (cber.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cber.getText().toString());
                        i++;
                    }
                    if (cbit.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbit.getText().toString());
                        i++;
                    }
                    if (cbie.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbie.getText().toString());
                        i++;
                    }
                    if (cbme.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbme.getText().toString());
                        i++;
                    }
                    if (cbma.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbma.getText().toString());
                        i++;
                    }
                    if (cbmp.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbmp.getText().toString());
                        i++;
                    }
                    if (cbmr.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbmr.getText().toString());
                        i++;
                    }
                    if (cbpe.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbpe.getText().toString());
                        i++;
                    }
                    if (cbpt.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbpt.getText().toString());
                        i++;
                    }
                    if (cbprt.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbprt.getText().toString());
                        i++;
                    }
                    if (cbhmct.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbhmct.getText().toString());
                        i++;
                    }
                    if (cbpsrt.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbpsrt.getText().toString());
                        i++;
                    }
                    if (cbmechtr.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbmechtr.getText().toString());
                        i++;
                    }
                    if (cbcfis.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbcfis.getText().toString());
                        i++;
                    }
                    if (cbcee.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbcee.getText().toString());
                        i++;
                    }
                    if (cbbc.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbbc.getText().toString());
                        i++;
                    }
                    if (cbca.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbca.getText().toString());
                        i++;
                    }
                    if (cbcddm.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbcddm.getText().toString());
                        i++;
                    }
                    if (cbid.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbid.getText().toString());
                        i++;
                    }
                    if (cbmom.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbmom.getText().toString());
                        i++;
                    }
                    if (cbtd.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbtd.getText().toString());
                        i++;
                    }
                    if (cbfd.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbfd.getText().toString());
                        i++;
                    }
                    if (cbftd.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbftd.getText().toString());
                        i++;
                    }
                    if (cbvg.isChecked()) {
                        if (i != 0) {
                            Eligible_branches = Eligible_branches.concat(", ");
                        }
                        Eligible_branches = Eligible_branches.concat(cbvg.getText().toString());
                        i++;
                    }

                    Recruitment_process = " ";
                    int j = 0;
                    if (rp_cbppt.isChecked()) {
                        if (j != 0) {
                            Recruitment_process = Recruitment_process.concat(", ");
                        }
                        Recruitment_process = Recruitment_process.concat(rp_cbppt.getText().toString());
                        j++;
                    }
                    if (rp_cbaptitude.isChecked()) {
                        if (j != 0) {
                            Recruitment_process = Recruitment_process.concat(", ");
                        }
                        Recruitment_process = Recruitment_process.concat(rp_cbaptitude.getText().toString());
                        j++;
                    }
                    if (rp_cbotest.isChecked()) {
                        if (j != 0) {
                            Recruitment_process = Recruitment_process.concat(", ");
                        }
                        Recruitment_process = Recruitment_process.concat(rp_cbotest.getText().toString());
                        j++;
                    }
                    if (rp_cbhrinterview.isChecked()) {
                        if (j != 0) {
                            Recruitment_process = Recruitment_process.concat(", ");
                        }
                        Recruitment_process = Recruitment_process.concat(rp_cbhrinterview.getText().toString());
                        j++;
                    }
                    if (rp_cbtechtest.isChecked()) {
                        if (j != 0) {
                            Recruitment_process = Recruitment_process.concat(", ");
                        }
                        Recruitment_process = Recruitment_process.concat(rp_cbtechtest.getText().toString());
                        j++;
                    }
                    if (rp_cbgd.isChecked()) {
                        if (j != 0) {
                            Recruitment_process = Recruitment_process.concat(", ");
                        }
                        Recruitment_process = Recruitment_process.concat(rp_cbgd.getText().toString());
                        j++;
                    }
                    if (rp_cbtechinterview.isChecked()) {
                        if (j != 0) {
                            Recruitment_process = Recruitment_process.concat(", ");
                        }
                        Recruitment_process = Recruitment_process.concat(rp_cbtechinterview.getText().toString());
                        j++;
                    }

                    photocopy_doc = " ";
                    int k = 0;
                    if (phdoc_cb_tenth.isChecked()) {
                        if (k != 0) {
                            photocopy_doc = photocopy_doc.concat(", ");
                        }
                        photocopy_doc = photocopy_doc.concat(phdoc_cb_tenth.getText().toString());
                        k++;
                    }
                    if (phdoc_cb_tenthc.isChecked()) {
                        if (k != 0) {
                            photocopy_doc = photocopy_doc.concat(", ");
                        }
                        photocopy_doc = photocopy_doc.concat(phdoc_cb_tenthc.getText().toString());
                        k++;
                    }
                    if (phdoc_cb_twelth.isChecked()) {
                        if (k != 0) {
                            photocopy_doc = photocopy_doc.concat(", ");
                        }
                        photocopy_doc = photocopy_doc.concat(phdoc_cb_twelth.getText().toString());
                        k++;
                    }
                    if (phdoc_cb_twelthc.isChecked()) {
                        if (k != 0) {
                            photocopy_doc = photocopy_doc.concat(", ");
                        }
                        photocopy_doc = photocopy_doc.concat(phdoc_cb_twelthc.getText().toString());
                        k++;
                    }
                    if (phdoc_cb_diploma.isChecked()) {
                        if (k != 0) {
                            photocopy_doc = photocopy_doc.concat(", ");
                        }
                        photocopy_doc = photocopy_doc.concat(phdoc_cb_diploma.getText().toString());
                        k++;
                    }
                    if (phdoc_cb_diplomac.isChecked()) {
                        if (k != 0) {
                            photocopy_doc = photocopy_doc.concat(", ");
                        }
                        photocopy_doc = photocopy_doc.concat(phdoc_cb_diplomac.getText().toString());
                        k++;
                    }
                    if (phdoc_cb_pancard.isChecked()) {
                        if (k != 0) {
                            photocopy_doc = photocopy_doc.concat(", ");
                        }
                        photocopy_doc = photocopy_doc.concat(phdoc_cb_pancard.getText().toString());
                        k++;
                    }
                    if (phdoc_cb_aadhar.isChecked()) {
                        if (k != 0) {
                            photocopy_doc = photocopy_doc.concat(", ");
                        }
                        photocopy_doc = photocopy_doc.concat(phdoc_cb_aadhar.getText().toString());
                        k++;
                    }
                    if (phdoc_cb_bankbook.isChecked()) {
                        if (k != 0) {
                            photocopy_doc = photocopy_doc.concat(", ");
                        }
                        photocopy_doc = photocopy_doc.concat(phdoc_cb_bankbook.getText().toString());
                        k++;
                    }


                    original_doc = " ";
                    int l = 0;

                    if (original_cb_tenth.isChecked()) {
                        if (l != 0) {
                            original_doc = original_doc.concat(", ");
                        }
                        original_doc = original_doc.concat(original_cb_tenth.getText().toString());
                        l++;
                    }
                    if (original_cb_tenthc.isChecked()) {
                        if (l != 0) {
                            original_doc = original_doc.concat(", ");
                        }
                        original_doc = original_doc.concat(original_cb_tenthc.getText().toString());
                        l++;
                    }
                    if (original_cb_twelth.isChecked()) {
                        if (l != 0) {
                            original_doc = original_doc.concat(", ");
                        }
                        original_doc = original_doc.concat(original_cb_twelth.getText().toString());
                        l++;
                    }
                    if (original_cb_twelthc.isChecked()) {
                        if (l != 0) {
                            original_doc = original_doc.concat(", ");
                        }
                        original_doc = original_doc.concat(original_cb_twelthc.getText().toString());
                        l++;
                    }
                    if (original_cb_diploma.isChecked()) {
                        if (l != 0) {
                            original_doc = original_doc.concat(", ");
                        }
                        original_doc = original_doc.concat(original_cb_diploma.getText().toString());
                        l++;
                    }
                    if (original_cb_diplomac.isChecked()) {
                        if (l != 0) {
                            original_doc = original_doc.concat(", ");
                        }
                        original_doc = original_doc.concat(original_cb_diplomac.getText().toString());
                        l++;
                    }

                    if (original_cb_pancard.isChecked()) {
                        if (l != 0) {
                            original_doc = original_doc.concat(", ");
                        }
                        original_doc = original_doc.concat(original_cb_pancard.getText().toString());
                        l++;
                    }
                    if (original_cb_aadhar.isChecked()) {
                        if (l != 0) {
                            original_doc = original_doc.concat(", ");
                        }
                        original_doc = original_doc.concat(original_cb_aadhar.getText().toString());
                        l++;
                    }

                }

                {
                    int h = 0;
                    pass_year = "";
                    if (cb_passyear1.isChecked()) {
                        if (h != 0) {
                            pass_year = pass_year.concat(", ");
                        }
                        pass_year = pass_year.concat(cb_passyear1.getText().toString());
                        h++;
                    }
                    if (cb_passyear2.isChecked()) {
                        if (h != 0) {
                            pass_year = pass_year.concat(", ");
                        }
                        pass_year = pass_year.concat(cb_passyear2.getText().toString());
                        h++;
                    }
                    if (cb_passyear3.isChecked()) {
                        if (h != 0) {
                            pass_year = pass_year.concat(", ");
                        }
                        pass_year = pass_year.concat(cb_passyear3.getText().toString());
                        h++;
                    }
                    if (cb_passyear4.isChecked()) {
                        if (h != 0) {
                            pass_year = pass_year.concat(", ");
                        }
                        pass_year = pass_year.concat(cb_passyear4.getText().toString());
                        h++;
                    }
                    if (cb_passyear5.isChecked()) {
                        if (h != 0) {
                            pass_year = pass_year.concat(", ");
                        }
                        pass_year = pass_year.concat(cb_passyear5.getText().toString());
                        h++;
                    }
                }

                {
                    int genderid = rggender.getCheckedRadioButtonId();
                    System.out.println("radio button id :" + genderid);
                    if (genderid != -1) {
                        rbgender = (RadioButton) rggender.findViewById(genderid);
                        gender = rbgender.getText().toString();
                    }

                    int res_fac_id = rgresfaci.getCheckedRadioButtonId();
                    if (res_fac_id != -1) {
                        rbresfaci = (RadioButton) findViewById(res_fac_id);
                        resi_faci = rbresfaci.getText().toString();
                    }


                    int trans_fac_id = rgtransfaci.getCheckedRadioButtonId();
                    if (trans_fac_id != -1) {
                        rbtransfaci = (RadioButton) findViewById(trans_fac_id);
                        trans_faci = rbtransfaci.getText().toString();
                    }


                    int food_fac_id = rgfoodfaci.getCheckedRadioButtonId();
                    if (food_fac_id != -1) {
                        rbfodfaci = (RadioButton) findViewById(food_fac_id);
                        food_faci = rbfodfaci.getText().toString();
                    }


                    int resume_id = rgresume.getCheckedRadioButtonId();
                    if (resume_id != -1) {
                        rbresume = (RadioButton) findViewById(resume_id);
                        resume_cv = rbresume.getText().toString();
                    }
                }

                {

                    if (resi_faci.equals(" ")) {
                        resi_faci = "";
                    }
                    if (trans_faci.equals(" ")) {
                        trans_faci = "";
                    }
                    if (food_faci.equals(" ")) {
                        food_faci = "";
                    }
                    if (Recruitment_process.equals(" ")) {
                        Recruitment_process = "";
                    }
                    if (photocopy_doc.equals(" ")) {
                        photocopy_doc = "";
                    }
                    if (original_doc.equals(" ")) {
                        original_doc = "";
                    }
                    if (resume_cv.equals(" ")) {
                        resume_cv = "";
                    }
                    if (REG_FORM.equals(" ")) {
                        REG_FORM = "";
                    }
                }

                if (COMPANY_NAME.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Company Name can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if(!URLUtil.isValidUrl(WEB_URL) && !WEB_URL.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Web URL entered is not a valid URL link.", Toast.LENGTH_LONG)
                            .show();
                }
                else if (COMP_PROFILE.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Company Profile can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if (Eligible_branches.equals(" "))
                {
                    Toast.makeText(getBaseContext(), "Eligible Branches can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if (pass_year == null)
                {
                    Toast.makeText(getBaseContext(), "Passing Year can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if (gender.equals(" "))
                {
                    Toast.makeText(getBaseContext(), "Gender can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if(DESIGNATION.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Designation can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if(PAY.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Pay per month can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if(TOTAL_POST.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Total Opening/Post can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if (CAMPUS_VENUE.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Campus Venue can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if (CAMPUS_DATE.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Campus Date can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else if (CAMPUS_TIME.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Campus Time can not be left blank.", Toast.LENGTH_LONG)
                            .show();
                }
                else
                {
                    Intent intent=new Intent(v.getContext(), preview_tpo.class);
                    intent.putExtra("collegename",College_name);
                    intent.putExtra("companyname",COMPANY_NAME);
                    intent.putExtra("companyaddress",COMPANY_ADDRESS);
                    intent.putExtra("weburl",WEB_URL);
                    intent.putExtra("compprofile",COMP_PROFILE);
                    intent.putExtra("eligiblecolleges",Eligible_colleges);
                    intent.putExtra("eligiblebranches",Eligible_branches);
                    intent.putExtra("passyear",pass_year);
                    intent.putExtra("gender",gender);
                    intent.putExtra("tenthpercent",TENTH_PERCENT);
                    intent.putExtra("twelthpercent",TWELTH_PERCENT);
                    intent.putExtra("diploma",DIPLOMA_PERCENT);
                    intent.putExtra("backpaper",BACK_PAPER);
                    intent.putExtra("designation",DESIGNATION);
                    intent.putExtra("pay",PAY);
                    intent.putExtra("totalpost",TOTAL_POST);
                    intent.putExtra("residentialfacility",resi_faci);
                    intent.putExtra("transportfacility",trans_faci);
                    intent.putExtra("foodfacility",food_faci);
                    intent.putExtra("otherfacility",OTHER_FACILITY);
                    intent.putExtra("recruitmentprocess",Recruitment_process);
                    intent.putExtra("photocopydocument",photocopy_doc);
                    intent.putExtra("originaldocument",original_doc);
                    intent.putExtra("resume",resume_cv);
                    intent.putExtra("passportphoto",passport_photo);
                    intent.putExtra("campusvenue",CAMPUS_VENUE);
                    intent.putExtra("campusdate",CAMPUS_DATE);
                    intent.putExtra("campustime",CAMPUS_TIME);
                    intent.putExtra("contactinfo",CONTACT_INFO);
                    intent.putExtra("regform",REG_FORM);
                    intent.putExtra("otherinfo",OTHER_INFO);

                    v.getContext().startActivity(intent);
                }

            }
        });

    }

    public void DateDialog(){
        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth)
            {
                campus_date.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
            }};
        DatePickerDialog dpDialog=new DatePickerDialog(this, listener, year, month, day);
        dpDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dpDialog.show();
    }

    public void TimeDialog(){
        TimePickerDialog.OnTimeSetListener listener1 = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                if(hourOfDay < 12)
                {
                    AM__PM = "AM";
                }
                else
                {
                    if (hourOfDay > 12)
                    {
                        hourOfDay = hourOfDay-12;
                    }
                    AM__PM = "PM";
                }

                if(hourOfDay<10)
                {
                    hour_m = "0"+hourOfDay;
                }
                else
                {
                    hour_m = ""+hourOfDay;
                }
                if(minute<10)
                {
                    minute_m ="0"+minute;
                }
                else
                {
                    minute_m = ""+minute;
                }


                campus_time.setText(hour_m + " : " + minute_m + " " + AM__PM );
            }
        };
        TimePickerDialog tpDialog = new TimePickerDialog(this,listener1,hour,minute,mode);
        tpDialog.show();
    }

}